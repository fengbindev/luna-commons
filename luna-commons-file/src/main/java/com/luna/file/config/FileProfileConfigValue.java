package com.luna.file.config;

import com.luna.common.utils.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author luna
 */
@Component
@ConfigurationProperties(prefix = "luna.file")
public class FileProfileConfigValue {
    /** 项目名称 */
    private String         name;

    /** 版本 */
    private String         version;

    /** 版权年份 */
    private String         copyrightYear;

    /** 上传路径 */
    private static String  profile;

    /** 获取地址开关 */
    private static boolean addressEnabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        FileProfileConfigValue.profile = profile;
    }

    public static boolean isAddressEnabled() {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled) {
        FileProfileConfigValue.addressEnabled = addressEnabled;
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath() {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath(String basePath) {
        if (StringUtils.isBlank(getProfile())) {
            return basePath + "/download/";
        } else {
            return getProfile() + "/download/";
        }
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath() {
        return getProfile() + "/upload";
    }
}