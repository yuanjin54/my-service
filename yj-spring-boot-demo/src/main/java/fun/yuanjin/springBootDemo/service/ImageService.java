package fun.yuanjin.springBootDemo.service;

import fun.yuanjin.springBootDemo.domain.Image;

/**
 * @ClassName ImageService
 * @Description TODO
 * @Author yuanjin
 * @Date 2020-11-05 21:50
 * @Version 1.0
 */
public interface ImageService {
    String test();
    void addOneImage(Image image);
    void addBatchImage();
    void deleteBatchImage();
    String select();
    void saveImage(Image image);
}
