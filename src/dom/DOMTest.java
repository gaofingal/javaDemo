package dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMTest {
    public static void main(String[] args) throws Exception {
        //文件路径
        File f = new File("E:/java/javaDemo/contacts.xml");
        //读取该文件
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(f);
        //获取根节点
        Element root = doc.getDocumentElement();
        //获取一个字节点
        NodeList linkman = root.getElementsByTagName("linkman");
        Element linkmanFist = (Element) linkman.item(0);
        //获取邮箱信息
        NodeList email = linkmanFist.getElementsByTagName("email");
        String emailName = email.item(0).getTextContent();
        System.out.println(emailName);

        System.out.println("-----------------------------------");
        email.item(0).setTextContent("huhu@gaogao");

        //转换器
        TransformerFactory factory1 = TransformerFactory.newInstance();
        Transformer transformer = factory1.newTransformer();

        //资源
        Source source = new DOMSource(doc);
        Result result = new StreamResult(f);

        //转化写入
        transformer.transform(source, result);
    }
}
