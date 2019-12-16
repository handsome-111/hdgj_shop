package com.hdgj.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.alibaba.fastjson.JSONObject;

public class FirstLucene {
		
	public static void main(String[] args) throws Exception {
		FirstLucene fl = new FirstLucene();
		fl.index(new ArrayList());
	}
	public void index(List<JSONObject> list) throws Exception {
		IndexWriter indexWriter = getIndexWriter();
		
		Document temp = new Document();
		for(JSONObject jsonObject: list){
			Field fileNameField = new TextField("fileName", "给哈哈哈啊", Store.YES);
			temp.add(fileNameField);
			//使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
			indexWriter.addDocument(temp);
		}
		//关闭IndexWriter对象。
        indexWriter.close();
	}
	
	public void indexSearch() throws Exception {
		IndexSearcher indexSearcher = getIndexSearcher();
        
        //创建查询条件
        //使用MatchAllDocsQuery查询索引目录中的所有文档
        Query query = new MatchAllDocsQuery();
        //执行查询
        //第一个参数是查询对象，第二个参数是查询结果返回的最大值
        TopDocs topDocs = indexSearcher.search(query, 10);
        
        //查询结果的总条数
        System.out.println("查询结果的总条数："+ topDocs.totalHits);
        //遍历查询结果
        //topDocs.scoreDocs存储了document对象的id
        //ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //scoreDoc.doc属性就是document对象的id
            //int doc = scoreDoc.doc;
            //根据document的id找到document对象
            Document document = indexSearcher.doc(scoreDoc.doc);
            //文件名称
            System.out.println(document.get("fileName"));
            //文件内容
        }
        //关闭indexreader对象
        indexSearcher.getIndexReader().close();
	}
	
	public void indexDelete() throws Exception{
		IndexWriter indexWriter = getIndexWriter();
        //删除全部索引
        indexWriter.deleteAll();
        //关闭indexwriter
        indexWriter.close();
	}
	
	public IndexWriter getIndexWriter() throws Exception{
		String path = "C:\\Users\\Administrator\\Desktop\\hdgj-shop\\server\\hdgj-api\\src\\main\\resources\\luceneIndexDatabase";
		Path p = Paths.get(path);
		//创建一个Directory对象，指定索引库存放的路径
        Directory directory = FSDirectory.open(p);
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        return indexWriter;
	}
	
	public IndexSearcher getIndexSearcher() throws Exception {
		String path = "C:\\Users\\Administrator\\Desktop\\hdgj-shop\\server\\hdgj-api\\src\\main\\resources\\luceneIndexDatabase";
		Path p = Paths.get(path);
		//创建一个Directory对象，指定索引库存放的路径
        Directory directory = FSDirectory.open(p);
        //创建IndexReader对象，需要指定Directory对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //创建Indexsearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        return indexSearcher;
	}
	
	//使用MatchAllDocsQuery查询索引目录中的所有文档
	public void matchAllDocsQuery() throws Exception{ 
        IndexSearcher indexSearcher = getIndexSearcher();
        Query query = new MatchAllDocsQuery();
	}
	
	//TermQuery,通过项查询，TermQuery不使用分析器所以建议匹配不分词的Field域查询，比如订单号，ID等
	public void TermQuery() throws Exception{
		 IndexSearcher indexSearcher = getIndexSearcher();
		 Query query = NumericDocValues.range(minDoc, maxDoc)
	}
}
