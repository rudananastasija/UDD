package com.example.naucna.config;

import javax.annotation.PostConstruct;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.example.naucna.model.RecenzentUnit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import java.io.IOException;
import java.util.ArrayList;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
@Configuration
public class ElasticSearchConfiguration {
	@Autowired
	RestHighLevelClient client;
	
	@PostConstruct
	public void postConstruct() throws IOException {
		//zahtjevamo index da bismo postavili mapping u njega
		GetIndexRequest getIndex = new GetIndexRequest("index_rad"); 
		
		if(!client.indices().exists(getIndex, RequestOptions.DEFAULT)) {
			//ukoliko ne postoji vec, kreirati ga
			CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_rad"); 
			client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
			
			 PutMappingRequest mappingRequest = new PutMappingRequest("index_rad");
			 
			 XContentBuilder builder = XContentFactory.jsonBuilder();
			 builder.startObject();
			 {
			     builder.startObject("properties");
			     {
			    	 builder.startObject("magazin");
			         {
			             builder.field("analyzer", "serbian"); 
			        	 builder.field("type", "text");
			             builder.field("store", "true");
			         }
			         builder.endObject();
			         
			         builder.startObject("sadrzaj");
			         {    
			        	 builder.field("analyzer", "serbian");
				         builder.field("type", "text");
			             builder.field("store", "true");
			         }
			         builder.endObject();
				       
			         builder.startObject("naslov");
			         {
			        	 builder.field("analyzer", "serbian");
			        	 builder.field("type", "text");
			             builder.field("store", "true");
			         
			         }
			         builder.endObject();
			         
			    	 builder.startObject("koautori");
			         {    builder.field("analyzer", "serbian");
			             builder.field("type", "text");
			             builder.field("store", "true");
			         }
			         builder.endObject();
			         
			         
			         builder.startObject("kljucneRijeci");
			         {
			        	 builder.field("analyzer", "serbian");
			             builder.field("type", "text");
			             builder.field("store", "true");
			         }
			         
			         builder.endObject();
			         
			         builder.startObject("id");
			         {
			             builder.field("type", "keyword");
			         }
			         builder.endObject();
			         
			         
			         builder.startObject("naucnaOblast");
			         {

			             builder.field("analyzer", "serbian");
			             builder.field("type", "text");
			             builder.field("store", "true");
			         }
			         builder.endObject();
			       

			         builder.startObject("openAccess");
			         {

			             builder.field("analyzer", "serbian");
			             builder.field("type", "text");
			             builder.field("store", "true");
			         }
			         builder.endObject();
			          
			         
			     }
			     builder.endObject();
			 }
			 builder.endObject();
			 mappingRequest.source(builder); 
			 client.indices().putMapping(mappingRequest, RequestOptions.DEFAULT);
		}
			 //formiranje indeksa recenzenata
			 GetIndexRequest getIndex2 = new GetIndexRequest("index_recenzenti"); 
				
				if(!client.indices().exists(getIndex2, RequestOptions.DEFAULT)) {
						System.out.println("dosao da napravi index rec");
						CreateIndexRequest createIndex = new CreateIndexRequest("index_recenzenti"); 
						client.indices().create(createIndex, RequestOptions.DEFAULT);
					    PutMappingRequest mappingReq = new PutMappingRequest("index_recenzenti");
					    XContentBuilder builder2 = XContentFactory.jsonBuilder();
					 
					    builder2.startObject();
					 {
						 builder2.startObject("properties");
					     {
					         
					    	 builder2.startObject("username");
					         {
					        	 builder2.field("type", "keyword");
					         } 
					         builder2.endObject();
					            
					         builder2.startObject("lokacija");
					         {
					        	 builder2.field("type", "geo_point");
					         }
					         builder2.endObject();
					     }
					     builder2.endObject();
					 }
					 builder2.endObject();
					 mappingReq.source(builder2); 
					 client.indices().putMapping(mappingReq, RequestOptions.DEFAULT);
			 //indeksiranje recenzenata
			 
			 ArrayList<RecenzentUnit> recenzenti = new ArrayList<RecenzentUnit>();
			 recenzenti.add(new RecenzentUnit("rec1",(float)45.267136, (float)19.833549));
			 recenzenti.add(new RecenzentUnit("rec2",(float)40.7128, (float)-74.0060));
			 recenzenti.add(new RecenzentUnit("rec3",(float)44.7866, (float)20.4489));
			 recenzenti.add(new RecenzentUnit("rec4",(float)48.2082, (float)16.3738));
			 recenzenti.add(new RecenzentUnit("rec5",(float)11.7866, (float)10.1234));
			
			 for(RecenzentUnit rec : recenzenti) {
				System.out.println("konfiguracija recenzenta"+rec.getUsername());
				 IndexRequest request = new IndexRequest("index_recenzenti");
				 request.id(rec.getUsername());
				 ObjectMapper mapper = new ObjectMapper();
					
				 request.source(mapper.writeValueAsString(rec), XContentType.JSON);
				 client.index(request, RequestOptions.DEFAULT);
					
					
			 }
							
		}
	}
	
	
	
}
