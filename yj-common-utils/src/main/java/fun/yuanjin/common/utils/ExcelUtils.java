package fun.yuanjin.common.utils;

import com.google.common.collect.Lists;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * Created by liyu on 2017/10/17.
 */
public class ExcelUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger("ss");


    /**
     * 从MultipartFile中获取File，用于上传文件的处理
     *
     * @param multipartFile 用户上传的MultipartFile
     * @return 获取的File
     */
    public static File getFileFromMultipartFile(MultipartFile multipartFile) {
        File tmpFile = null;
        try {
            tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + multipartFile.getOriginalFilename());
            multipartFile.transferTo(tmpFile);
        } catch (IOException e) {
            String message = "multipartFile transferTo file error";
            LOGGER.error(message, e);
            throw new RuntimeException(message, e);
        }
        return tmpFile;
    }


    public static Sheet getDefaultSheetFromExcelFile(File file) {
        Sheet sheet = null;
        try {
            Workbook workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            String errorMessage = "read file error.";
            LOGGER.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        } catch (InvalidFormatException e) {
            String errorMessage = "InvalidFormat, not Excel file.";
            LOGGER.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
        return sheet;
    }

    public static boolean sizeCheck(File file, int maxSize) {
        Sheet sheet = getDefaultSheetFromExcelFile(file);
        return sheet.getLastRowNum() < maxSize;
    }



    public static <R> List<R> parseData(File file, Function<Row, R> parse) {
        Sheet sheet = getDefaultSheetFromExcelFile(file);
        List<R> result = Lists.newArrayList();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            result.add(parse.apply(row));
        }

        return result;
    }

    /**
     * 获取字符串值
     *
     * @param cell excel单元格
     * @return 字符串值
     */
    public static String getStringValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                String value = cell.getStringCellValue().trim();
                if ("NULL".equals(value)) {
                    return null;
                }
                return value;
            case NUMERIC:
                DecimalFormat df = new DecimalFormat("########.########");
                return df.format(cell.getNumericCellValue());
            default:
                return null;
        }
    }

    /**
     * 获取整型值
     *
     * @param cell excel单元格
     * @return 整型值
     */
    public static Integer getIntValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return Integer.parseInt(cell.getStringCellValue().trim());
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            default:
                return null;
        }
    }

    /**
     * 获取浮点值
     *
     * @param cell excel单元格
     * @return 浮点值
     */
    public static Double getDoubleValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return Double.parseDouble(cell.getStringCellValue().trim());
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return null;
        }
    }

    /**
     * 获取长整形值
     *
     * @param cell excel单元格
     * @return 浮点值
     */
    public static Long getLongValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return Long.parseLong(cell.getStringCellValue().trim());
            case NUMERIC:
                return (long)cell.getNumericCellValue();
            default:
                return null;
        }
    }

    /**
     * 获取字符串值
     *
     * @param cell excel单元格
     * @return 字符串值
     */
    public static Date getDateValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        return cell.getDateCellValue();
    }

}
