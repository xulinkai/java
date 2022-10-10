package com.aggregation.common.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc
 * @created by xlk on 2022/7/18 11:36
 */
@Slf4j
public class FileUrlInfoUtil {


    /**
     * @Desc 保存文件url信息 注：该表暂时做增量更新
     */
    /*
    @Override
    public void saveFileUrl(String urlKey, FileBussTypeEnum fileBussType, List<String> urls) {
        log.info("保存文件url信息 urlKey:{}, fileBussType:{}, urls:{}", urlKey, fileBussType.getDesc(), urls);
        if (CollectionUtils.isEmpty(urls)) {
            return;
        }

        for (String url : urls) {
            FileUrlInfo build = FileUrlInfo.builder().url(url).fileBussType(fileBussType.getCode()).fileBussTypeDesc(fileBussType.getDesc()).urlKey(urlKey).build();
            insert(build);
        }
    }

    */
    /**
     * @Desc 通过url字符串保存 用url_key去替换  并保存值t_file_url_info中
     */
    /*
    @Override
    public void replaceUrlByUrlKey(Object object, String fieldName, FileBussTypeEnum fileBussType) {
        Map<String, Field> fieldMap = StoreBeanUtils.getFieldMap(object);
        Field field = fieldMap.get(fieldName);
        field.setAccessible(true);
        try {
            Object fieldVale = field.get(object);
            if (Objects.nonNull(fieldVale)) {
                String urls = PathUtil.removeSuffixComma(String.valueOf(fieldVale));
                String urlKey = UUID.randomUUID().toString().replace("-", "");
                saveFileUrl(urlKey, fileBussType, Arrays.asList(StringUtils.split(urls, ",")));
                field.set(object, urlKey);
            }
        } catch (Exception e) {
            log.error("反射获取属性失败", e);
            throw new RuntimeException(e);
        }
    }


    */

    /**
     * @Desc 从通过对象属性（值为urlKey） 从库中获取对应url信息 并设置给当前属性值
     */
    /*
    @Override
    public void replaceUrlKeyByUrl(Object object, String... fieldNameList) {
        Map<String, Field> fieldMap = StoreBeanUtils.getFieldMap(object);
        for (String fieldName : fieldNameList) {
            Field field = fieldMap.get(fieldName);
            field.setAccessible(true);
            try {
                Object fieldVale = field.get(object);
                if (Objects.nonNull(fieldVale)) {
                    String urlKey = String.valueOf(fieldVale);
                    List<String> urlList = selectUrlListByUrlKey(urlKey);
                    field.set(object, StringUtils.join(urlList, ","));
                }
            } catch (IllegalAccessException e) {
                log.error("反射获取属性失败", e);
                throw new RuntimeException(e);
            }
        }
    }
    */
    /**
     * @Desc 获取url集合
     */
    /*
    @Override
    public List<String> selectUrlListByUrlKey(String urlKey) {
        List<FileUrlInfo> fileUrlInfos = selectByEntity(FileUrlInfo.builder().urlKey(urlKey).build());
        if (CollectionUtils.isNotEmpty(fileUrlInfos)) {
            return fileUrlInfos.stream().map(FileUrlInfo::getUrl).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<FileUrlInfo> selectByEntity(FileUrlInfo fileUrlInfo) {
        EntityWrapper<FileUrlInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.setEntity(fileUrlInfo);
        return selectList(entityWrapper);
    }*/

}
