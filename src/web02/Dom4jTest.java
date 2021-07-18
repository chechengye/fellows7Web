package web02;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4jTest {

    public static void main(String[] args) {
        try {
            SAXReader sr = new SAXReader();
            //1、获取创建Document文档流对象
            Document document = sr.read("src/xmlDemo.xml");
            //2、使用文档流对象获取根元素
            Element rootElement = document.getRootElement();
            System.out.println("根元素 : " + rootElement.getName());

            List<Element> elements = rootElement.elements();//获取所有子元素
            for(Element e : elements){
                System.out.println("属性值 ： " + e.attributeValue("id"));
                if("001".equals(e.attributeValue("id"))){//寻找到了第一个人的元素
                    List<Element> per = e.elements();
                    for(Element ee : per){
                        if(ee.getName().equals("name")){
                            System.out.println("名称为：" + ee.getText());
                        }
                        if(ee.getName().equals("age")){
                            System.out.println("年龄为: " + ee.getText());
                        }
                    }
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
