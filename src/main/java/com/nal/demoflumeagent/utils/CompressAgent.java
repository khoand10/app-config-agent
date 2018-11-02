package com.nal.demoflumeagent.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressAgent {
    public static final String OUTPUT_ZIP_FILE = "./agent.zip";
    public static final String SOURCE_FOLDER = "./apache-flume-1.8.0-bin";
    public static final byte[] BUFFER = new byte[1024];

//    public static void main(String[] args) {
//        File outputZipFile = new File(OUTPUT_ZIP_FILE);
//        File inputDir = new File(SOURCE_FOLDER);
//        zipDirectory(inputDir, outputZipFile);
//    }

    public void zipDirectory() {
        File outputZipFile = new File(OUTPUT_ZIP_FILE);
        File inputDir = new File(SOURCE_FOLDER);
        // Tạo thư mục cha cho file đầu ra (output file).
        outputZipFile.getParentFile().mkdirs();

        String inputDirPath = inputDir.getAbsolutePath();

        FileOutputStream fos = null;
        ZipOutputStream zipOs = null;
        try {

            List<File> allFiles = listChildFiles(inputDir);

            // Tạo đối tượng ZipOutputStream để ghi file zip.
            fos = new FileOutputStream(outputZipFile);
            zipOs = new ZipOutputStream(fos);
            for (File file : allFiles) {
                String filePath = file.getAbsolutePath();

                //System.out.println("Zipping " + filePath);
                // entryName: is a relative path.
                String entryName = filePath.substring(inputDirPath.length() + 1);

                ZipEntry ze = new ZipEntry(entryName);
                // Thêm entry vào file zip.
                zipOs.putNextEntry(ze);
                // Đọc dữ liệu của file và ghi vào ZipOutputStream.
                FileInputStream fileIs = new FileInputStream(filePath);

                int len;
                while ((len = fileIs.read(BUFFER)) > 0) {
                    zipOs.write(BUFFER, 0, len);
                }
                fileIs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(zipOs);
            closeStream(fos);
        }

    }

    private static void closeStream(OutputStream out) {
        try {
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Lấy danh sách các file trong thư mục:
     * bao gồm tất cả các file con, cháu,.. của thư mục đầu vào.
     */
    private List<File> listChildFiles(File dir) throws IOException {
        List<File> allFiles = new ArrayList<>();

        File[] childFiles = dir.listFiles();
        for (File file : childFiles) {
            if (file.isFile()) {
                allFiles.add(file);
            } else {
                List<File> files = listChildFiles(file);
                allFiles.addAll(files);
            }
        }
        return allFiles;
    }

}
