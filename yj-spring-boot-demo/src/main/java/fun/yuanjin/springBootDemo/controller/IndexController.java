package fun.yuanjin.springBootDemo.controller;

import fun.yuanjin.springBootDemo.exector.TokenBucketExecutor;
import fun.yuanjin.springBootDemo.service.TdcCostService;
import groovy.util.logging.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 21:44
 * @Version 1.0
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private TdcCostService tdcCostService;

    @Autowired
    private TokenBucketExecutor tokenBucketExecutor;

    @RequestMapping
    public String doTask() {
//        tokenBucketExecutor.doTask();
        return "success";
    }


    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadExcel(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (file.isEmpty()) {
            return "failed";
        }
        File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + file.getOriginalFilename());
        file.transferTo(tmpFile);

        tdcCostService.deleteAll();

        Sheet sheet = null;
        try {
            Workbook workbook = WorkbookFactory.create(tmpFile);
            sheet = workbook.getSheetAt(0);
            //代码解释：获取sheet中最后一行行号
            int lastRowNum = sheet.getLastRowNum();
            System.out.println(lastRowNum);
            for (int i = 1; i <= 1000; i++) {
                //代码解释：获取当前行中的内容
                Row row = sheet.getRow(i);
                if (row == null) {
                    break;
                }
                tdcCostService.saveData(row, i);
            }

        } catch (IOException e) {
            String errorMessage = "read file error.";
            throw new RuntimeException(errorMessage, e);
        } catch (InvalidFormatException e) {
            String errorMessage = "InvalidFormat, not Excel file.";
            throw new RuntimeException(errorMessage, e);
        }
        return "success";
    }

    public static byte[] getBytes(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int len;
        byte[] data = new byte[100000];
        while ((len = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, len);
        }

        buffer.flush();
        return buffer.toByteArray();
    }
}
