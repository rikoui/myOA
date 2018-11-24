package com.bjdreamtech.entity;

public class SysFile {
    private String fileId;

    private String fileOriginalName;

    private String fileName;

    private String fileType;

    private String filePath;

    private String fileCreateAdmin;

    private String fileCreatetime;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getFileOriginalName() {
        return fileOriginalName;
    }

    public void setFileOriginalName(String fileOriginalName) {
        this.fileOriginalName = fileOriginalName == null ? null : fileOriginalName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileCreateAdmin() {
        return fileCreateAdmin;
    }

    public void setFileCreateAdmin(String fileCreateAdmin) {
        this.fileCreateAdmin = fileCreateAdmin == null ? null : fileCreateAdmin.trim();
    }

    public String getFileCreatetime() {
        return fileCreatetime;
    }

    public void setFileCreatetime(String fileCreatetime) {
        this.fileCreatetime = fileCreatetime == null ? null : fileCreatetime.trim();
    }
}