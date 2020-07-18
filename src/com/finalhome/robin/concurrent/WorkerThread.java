package com.finalhome.robin.concurrent;

public class WorkerThread implements Runnable{

    private String fileName;
    private int start;
    private int end;

    public WorkerThread(String fileName, int start, int end) {
        this.fileName = fileName;
        this.start = start;
        this.end = end;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("File: " + fileName);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
