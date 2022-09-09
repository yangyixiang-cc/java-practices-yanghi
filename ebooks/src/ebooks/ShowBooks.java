package ebooks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ShowBooks {
    private int num = 0;
    private Reptile o;
    public GuiShow s;
    public StringBuffer t;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Reptile getO() {
        return o;
    }

    public void setO(Reptile o) {
        this.o = o;
    }


    @Override
    public String toString() {
        return "ShowBooks [num=" + num + ", o=" + o + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + num;
        result = prime * result + ((o == null) ? 0 : o.hashCode());
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
        ShowBooks other = (ShowBooks) obj;
        if (num != other.num)
            return false;
        if (o == null) {
            if (other.o != null)
                return false;
        } else if (!o.equals(other.o))
            return false;
        return true;
    }

    public ShowBooks() {

    }

    public ShowBooks(int num, Reptile o, GuiShow s) {
        super();
        this.num = num;
        this.o = o;
        this.s = s;
        s.init();
    }

    //��ȡ�½�
    public void readChapter(int num) throws IOException {
        if (o == null) {
            System.out.println("�ļ�������");
        }
        Map col = o.getBook();
        File file = null;
        file = new File((String) col.get(num));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int dataCount;
        char[] data = new char[95];
        t = new StringBuffer();
        while ((dataCount = reader.read(data)) != -1) {
            t.append("  " + new String(data, 0, dataCount) + "\n");
            t.append("\n");
        }
        s.setArctice(t.toString());
        s.setTitle(file.getName().substring(0, file.getName().lastIndexOf('.')));
        reader.close();
        this.num = num;
    }

    //��һ��
    public void lastChapter() throws IOException {
        if (num == 1) {
            System.out.println("\t\t\t\t\t\t\t\t�޷��л����Ѿ��ǵ�һ����");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t�Ѿ��л�����һ��");
            readChapter(num - 1);
        }
    }

    //��һ��
    public void nextChapter() throws IOException {
        if (num == o.getBook().size()) {
            System.out.println("\t\t\t\t\t\t\t\t�޷��л����Ѿ������һ����");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t�Ѿ��л�����һ��");
            readChapter(num + 1);

        }

    }

    // Ŀ¼��ʾ
    public void directoryDisplay() {
        if (o == null) {
            System.out.println("�ļ�������");
        }
        Iterator valuecol = o.getBook().values().iterator();
        while (valuecol.hasNext()) {
            String t = (String) valuecol.next();
            System.out.println("\t\t\t\t\t\t\t\t" + t.substring(t.lastIndexOf("\\") + 1, t.lastIndexOf(".")));
        }
    }
}
