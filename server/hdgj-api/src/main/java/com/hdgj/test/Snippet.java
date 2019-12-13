package com.hdgj.test;

import java.io.File;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Snippet {
	/**
		 * 创建索引
		 */
		public void createIndex() throws Exception {
			String path = LoadTools.getSystemPath()+"/lucene/index/";
			//创建索引存放目录
			Directory directory = FSDirectory.open(Paths.get(path));
			//创建分析器
			Analyzer analyzer = new StandardAnalyzer();			//标准，官方分析器
			//指定分析器
			IndexWriterConfig config = new IndexWriterConfig(analyzer);
			/**
			 * 参数1：指定索引库的存放位置
			 * 参数2：指定一个分析器
			 */
	
			//需要存入索引的文件夹
			File file = new File("C:\\Users\\Administrator\\Desktop\\luceneDocument");
			File files[] = file.listFiles();
			for(File f : files){
				//声明文档(相当于数据库的行)
				Document document = new Document();
				/**
				 * 以下是声明字段
				 */
				//文件名
				String fileName = f.getName();
				Field fileNameField = new TextField("fieldName",fileName,Store.YES);
				//文件大小
				int fileSize = (int) f.length();
				Field fileSizeField = new IntPoint("fileSize",fileSize);
				//文件路径
				String filePath = f.getPath();
				Field filePathField = new StoredField("filePath",filePath);
				//文件内容
				String content = FileUtils.readFileToString(f, "GBK");
				Field contentField = new TextField("content",content,Store.YES);
				document.add(fileNameField);
				document.add(fileSizeField);
				document.add(filePathField);
				document.add(contentField);
				
				indexWriter.addDocument(document);
			}
			indexWriter.close();
		}
}

