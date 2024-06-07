package fileupload;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadProcess
 */
@WebServlet("/13FileUpload/UploadProcess.do")
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 1, 
		maxRequestSize = 1024 * 1024 * 10
)
public class UploadProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String saveDirectory = getServletContext().getRealPath("/Uploads");
			String originalFileName = FileUtil.uploadFile(request,  saveDirectory);
			String saveFileName = FileUtil.renameFile(saveDirectory, originalFileName);
			insertMyFile(request, originalFileName, saveFileName);
			response.sendRedirect("FileList.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "파일 업로드 오류");
			request.getRequestDispatcher("FileUploadMain.jsp").forward(request, response);
		}
	}
	
	private void insertMyFile(HttpServletRequest request , String oFileName , String sFileName) {
		String title = request.getParameter("title");
		String[] cateArray = request.getParameterValues("cate");
		StringBuffer cateBuf = new StringBuffer();
		if(cateArray == null) {
			cateBuf.append("선택한 항목 없음");
		}else {
			for(String s : cateArray) {
				cateBuf.append(s + ", ");
			}
		}
		MyFileDTO dto = new MyFileDTO();
		dto.setTitle(title);
		dto.setCate(cateBuf.toString());
		dto.setOfile(oFileName);
		dto.setSfile(sFileName);
		
		MyFileDAO dao = new MyFileDAO();
		dao.insertFile(dto);
		dao.close();
	}

}
