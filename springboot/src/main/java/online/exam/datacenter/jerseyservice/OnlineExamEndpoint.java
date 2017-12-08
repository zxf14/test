package online.exam.datacenter.jerseyservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import online.exam.datacenter.model.ExamCreation;
import online.exam.datacenter.model.TestInfo;

@Component
@Path("/onlineexam")

@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Online Exam API", produces = "application/json")
public class OnlineExamEndpoint {
		private static final Logger LOGGER = LoggerFactory.getLogger(OnlineExamEndpoint.class);
	
		  	@POST
		    @Path("/loadStudentList")
		    @Consumes(MediaType.MULTIPART_FORM_DATA)
		    @ApiOperation(
		            value = "上传考试学生名单")
		    @ApiResponses(value = {
		            @ApiResponse(code = 200, message = "OK", response = EndpointResponse.class),
		            @ApiResponse(code = 404, message = "NOT FOUND")
		    })
			public Response uploadFile(
					@ApiParam InputStream uploadedInputStream) {
		  		LOGGER.info("begin to upload student list!!");
		        String position = "/studentList/student.xlsx";
		        String uploadedFileLocation = null;
		        try{
		        	uploadedFileLocation = OnlineExamEndpoint.class.getResource(position).getPath();
		        }catch(Exception e){
		        	LOGGER.warn("\n\n\n Upload file path can not be retrieve, please check that!!\n\n\\n");
		        }

				// save it
				try {
					OutputStream out = new FileOutputStream(new File(
							uploadedFileLocation));
					int read = 0;
					byte[] bytes = new byte[1024];

					while ((read = uploadedInputStream.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
					out.flush();
					out.close();
					
					
				} catch (IOException e) {

					e.printStackTrace();
					EndpointResponse response = new EndpointResponse("failed","We can not upload for you now");
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
				}
				
				String output =  uploadedFileLocation;
				
				EndpointResponse response = new EndpointResponse("success",output);
				return Response.status(Response.Status.OK).entity(response).build();

			}
	  
	  	    
	    
	    @GET
	    @Path("/exam/{examID}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @ApiOperation(
	            value = "老师查看考试信息（不含试题信息）"
	            )
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "OK", response = TestInfo.class),
	            @ApiResponse(code = 404, message = "NOT FOUND")
	    })
	    public Response checkExam(@ApiParam @PathParam("examID") String examID) {
	    	
	    	
	    	EndpointResponse response = new EndpointResponse("success","http://localhost:8081/excel");
	        return Response.status(Response.Status.OK).entity(response).build();
	        
	        
	    }

	    
	    @POST
	    @Path("/startExam")
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    @ApiOperation(
	            value = "�ϴ�����")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "�ɹ�", response = EndpointResponse.class),
	            @ApiResponse(code = 404, message = "��Դ�e�`")
	    })
		public Response startExam(
				@ApiParam ExamCreation examInfo) {

	    	return null;
		}
}
