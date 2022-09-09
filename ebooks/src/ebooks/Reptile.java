package ebooks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * 1. ��װPython���������ģ��
 * 2. �������������ȡͼ�鲢�洢
 * */
public class Reptile implements Serializable {
    private static final long serialVersionUID = -5182532647273106745L;
    private Map book;

    public Map getBook() {
        return book;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((book == null) ? 0 : book.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reptile other = (Reptile) obj;
        if (book == null) {
            if (other.book != null)
                return false;
        } else if (!book.equals(other.book))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reptile [book=" + book.values() + "]";
    }

    public void setBook(Map book) {
        this.book = book;
    }

    public void installModule() throws IOException {
        Process p1 = Runtime.getRuntime().exec("python -c \"import requests\"");
        java.io.InputStream is = p1.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        if (br.readLine() == null) {
            System.out.println("requestsģ���Ѿ���װ");
        } else {
            System.out.println("���ڰ�װrequestsģ��--------------------");
            Process p2 = Runtime.getRuntime().exec("pip3 install requests");
            if (!p2.isAlive()) {
                System.out.println("requestsģ�鰲װ���");
            }
        }
        br.close();
    }

    public void callPython() throws IOException, InterruptedException {
        System.out.println("������ȡ");
        String url = "./CrawlingEBooks.py";
        String[] args1 = new String[]{"python ", url};
        Process pr = Runtime.getRuntime().exec(args1);
        BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line;
        int i = 1;
        book = new HashMap();
        while ((line = in.readLine()) != null) {
            book.put(i, line);
            i++;
        }
        in.close();
        pr.waitFor();
        pr.destroy();
        book.forEach((x, y) -> {
            System.out.println("��ȡ��ɣ�" + x + ":" + y);
        });
        System.out.println("��ȡ���");
    }
}
