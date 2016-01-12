package org.wltea.analyzer.sample;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class TestAnalyzer {

	public static void main(String[] args) {
		IKAnalyzer analyzer = new IKAnalyzer();
		String text = "三劫散仙是一个菜鸟";
		TokenStream ts;
		try {
			ts = analyzer.tokenStream("field", new StringReader(text));
			CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
			ts.reset();// 重置做准备
			while (ts.incrementToken()) {
				System.out.println(term.toString());
			}
			ts.end();//
			ts.close();// 关闭流
			analyzer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
