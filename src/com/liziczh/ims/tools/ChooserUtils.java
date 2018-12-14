package com.liziczh.ims.tools;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FilenameFilter;

public class ChooserUtils {
    // 选择文件
    public static String chooserFile(JButton btn){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xlsx Table", "xlsx");
        String path = null;
        chooser.setDialogTitle("请选择导入的*.xlsx文件...");
        chooser.setApproveButtonText("确定");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(filter);
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(btn)) {
            path = chooser.getSelectedFile().getPath();
        }
        return path;
    }
    // 选择目录
    public static String chooserDir(JButton btn){
        JFileChooser chooser = new JFileChooser();
        String path = null;
        chooser.setDialogTitle("请选择导出的文件夹...");
        chooser.setApproveButtonText("确定");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(btn)) {
            path = chooser.getSelectedFile().getPath();
        }
        return path;
    }
}
