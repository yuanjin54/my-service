package fun.yuanjin.springBootDemo.service.impl;

import fun.yuanjin.springBootDemo.dao.ImageDao;
import fun.yuanjin.springBootDemo.domain.Image;
import fun.yuanjin.springBootDemo.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ImageServiceImpl
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 22:03
 * @Version 1.0
 */
@Service
public class ImageServiceImpl implements ImageService {

    private ImageDao imageDao;

    private static final int START = 1;
    private static final int END = 2509938;

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(1, 10,
            100L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(100000), new ThreadPoolExecutor.CallerRunsPolicy());


    public ImageServiceImpl(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    @Override
    public String test() {
        return "test";
    }

    @Override
    public void addOneImage(Image image) {

    }

    @Override
    public void addBatchImage() {
        Image image = imageDao.selectOne();
        for (int id = START; id < END; id++) {
            image.setId((long) id);
            EXECUTOR_SERVICE.submit(() -> saveImage(image));
        }
    }

    @Override
    public void deleteBatchImage() {
        for (int id = START; id < END; id++) {
            int finalId = id;
            EXECUTOR_SERVICE.submit(() -> deleteImage((long) finalId));
        }
    }

    @Override
    public String select() {
        List<Image> images = imageDao.selectList();
        return images.get(0).toString();
    }

    @Override
    public void saveImage(Image image) {
        long id = imageDao.save(image);
        if (!StringUtils.isEmpty(image.getUrl()) && "4".equals(image.getUrl())){
            throw new RuntimeException("ee");
        }
    }

    public void deleteImage(Long id) {
        imageDao.deleteById(id);
    }
}
