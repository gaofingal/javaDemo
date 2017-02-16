package dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.annotation.Target;

public class CreateDOM {

    public static void main(String[] args) throws Exception {
        //xml文件
        File f = new File("E:/java/javaDemo/demo.xml");

        //先初始化一个Document 变量
        Document document = null;

        //实例化Document对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        if(f.exists()) {
            //存在解析
            document = builder.parse(f);
        }else {
            //不存在就创建
            document = builder.newDocument();
            document.setXmlVersion("1.0");
            Element root = document.createElement("contacts");
            document.appendChild(root);
        }

        //创建子节点
        Element root = document.getDocumentElement();
        Element linkman = document.createElement("linkman");
        Element name = document.createElement("name");
        Element telephone = document.createElement("telephone");
        Element age = document.createElement("age");

        //在子节点中添加文本节点
        name.setTextContent("huhu");
        age.setTextContent("18");
        telephone.setTextContent("177777");

        //将创建的元素添加到相对应的父级节点下
        root.appendChild(linkman);
        linkman.appendChild(name);
        linkman.appendChild(telephone);
        linkman.appendChild(age);

        //在element中设置属性
        linkman.setAttribute("id","1");

        //实例化转换对象
        TransformerFactory factory1 = TransformerFactory.newInstance();
        Transformer transformer = factory1.newTransformer();

        Source source = new DOMSource(document);
        Result result = new StreamResult(f);

        transformer.transform(source, result);
    }
}
