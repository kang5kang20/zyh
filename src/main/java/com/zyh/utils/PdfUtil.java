package com.zyh.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeEducation;
import com.zyh.entity.resume.ZyhResumeIntention;
import com.zyh.entity.resume.ZyhResumeIntentionExample;
import com.zyh.entity.resume.ZyhResumeSpeciality;
import com.zyh.entity.resume.ZyhResumeSpecialityExample;
import com.zyh.entity.resume.ZyhResumeWork;

public class PdfUtil {
	
	//边框属性值
		public static final int TOP = 1;
		public static final int BOTTOM = 2;
		public static final int LEFT = 4;
		public static final int RIGHT = 8;
		/**  
		* @Title: setOneRowWithDiffSize 
		* @author 代祯山  
		* @Description:同一行存在不同大小的字体
		* @param value
		* @param size
		* @return
		*/
		public static Paragraph setOneRowWithDiffSize(String[] value, int... size) {
			if (value.length == size.length) {
				Phrase phrase = new Phrase();
				for (int i = 0; i < size.length; i++) {
					phrase.add(new Chunk(value[i], 
							PdfUtil.getChineseFont(size[i])));
				}
				Paragraph paragraph = new Paragraph();
				paragraph.add(phrase);
				return paragraph;
			} else {
				return null;
			}
		}
		  /**  
			* @Title: getChineseFont 
			* @author 代祯山  
			* @Description:获取中文字体
			* @param size
			* @param weight
			* @return
			*/
			public static Font getChineseFont(int size){
				  try {
						 BaseFont bfChinese = BaseFont.
								 createFont("STSong-Light","UniGB-UCS2-H",
										 BaseFont.NOT_EMBEDDED);
						 return new Font(bfChinese, size, Font.NORMAL);
					} catch (Exception e) {
						return null;
					}
			  }
			public static Font getChineseFont(){
				return getChineseFont(11);
			}
			
			public static Font getChineseFont1(int size){
				  try {
						 BaseFont bfChinese = BaseFont.
								 createFont("STSong-Light","UniGB-UCS2-H",
										 BaseFont.NOT_EMBEDDED);
						 return new Font(bfChinese, size, Font.BOLD);
					} catch (Exception e) {
						return null;
					}
			  }
		/**  
		* @Title: notSetBorder 
		* @author 代祯山  
		* @Description:不设置哪一个边框
		* @param cell 
		* @param whichBordera
		*/
		public static void notSetBorder(PdfPCell cell,int whichBordera){
			cell.setBorder(Rectangle.NO_BORDER);
			if(LEFT==whichBordera||RIGHT==whichBordera
					||TOP==whichBordera||BOTTOM==whichBordera){
				switch (whichBordera) {
				case LEFT:
					cell.setBorder(Rectangle.TOP|
							Rectangle.RIGHT|Rectangle.BOTTOM);
					break;
				case RIGHT:
					cell.setBorder(Rectangle.LEFT|
							Rectangle.BOTTOM|Rectangle.TOP);
					break;
				case TOP:
					cell.setBorder(Rectangle.LEFT|
							Rectangle.RIGHT|Rectangle.BOTTOM);
					break;
				case BOTTOM:
					cell.setBorder(Rectangle.LEFT|Rectangle.RIGHT|Rectangle.TOP);
					break;
				default:
					break;
				}
			}
		}
		  /**  
		* @Title: createOneRowAsOneCell 
		* @author 代祯山  
		* @Description:创建表格的一个cell
		* @param val 要填充的值
		* @param cols 合并的列
		* @return
		*/
		public static PdfPCell createOneRowAsOneCell(String val,int cols){
			  BaseFont bfChinese = null;
			try {
				bfChinese = BaseFont.createFont(
						"STSong-Light","UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			} catch (Exception e) {
				return null;
			}
			if(null==val||"".equals(val)){
				val=" ";
			}
			  PdfPCell cell = new PdfPCell(
					  new Paragraph(val,new Font(bfChinese, 11, Font.NORMAL)));
			  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			  if(cols>1){
				  cell.setColspan(cols);
			  }
			  cell.setLeading(3, 1);
			  cell.setMinimumHeight(17f);
			  return cell;
		  }
		/**  
		* @Title: createOneRowAsOneCell 
		* @author 代祯山  
		* @Description:通过paragraph构建cell
		* @param paragraph
		* @param cols
		* @return
		*/
		public static PdfPCell createCellByParagraph(Paragraph paragraph,int cols){
			PdfPCell cell = new PdfPCell(paragraph);
			  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			  if(cols>1){
				  cell.setColspan(cols);
			  }
			  cell.setLeading(3, 1);
			  cell.setMinimumHeight(17f);
			return cell;
		}
		  /**  
		* @Title: createOneRowAsOneCell 
		* @author 代祯山  
		* @Description:  创建一个空行
		* @param cols 合并的列
		* @return
		*/
		public static PdfPCell createOneRowAsOneCell(int cols){
			  return createOneRowAsOneCell(null,cols);
		  }
		  /**  
		* @Title: createValCell 
		* @author 代祯山  
		* @Description:创建用于填充数据的row
		* @param val 要填充的值
		* @return
		*/
		public static PdfPCell createValCell(String val) {
			  return createOneRowAsOneCell( val,0);
		  }
		/**  
		* @Title: setVHBothCenter 
		* @author 代祯山  
		* @Description:  设置水平垂直都居中
		* @param cell
		*/
		public static void setVHBothCenter(PdfPCell cell) {
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		}

		/**  
		* @Title: setBorder 
		* @author 代祯山  
		* @Description:设置cell的那些边框显示
		* @param cell 
		* @param i 具体见上面的变量
		*/
		public static void setBorder(PdfPCell cell, int... i) {
			cell.setBorder(Rectangle.NO_BORDER);
			for (int j = 0; j < i.length; j++) {
				cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
			}
		}

		/**
		 * @Title: fillTemplateToDisk
		 * @author 代祯山
		 * @Description: 通过模本填充数据，生产PDF
		 * @param template
		 *            模板文件
		 * @param newPDF
		 *            新生产文件名
		 * @param data
		 *            数据
		 */
		public static void fillTemplateToDisk(String template, String newPDF, String... data) {
			System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
					"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
			PdfReader reader;
			FileOutputStream out;
			ByteArrayOutputStream bos;
			PdfStamper stamper;
			try {
				out = new FileOutputStream(newPDF);// 输出流
				reader = new PdfReader(template);// 读取pdf模板
				bos = new ByteArrayOutputStream();
				stamper = new PdfStamper(reader, bos);
				AcroFields form = stamper.getAcroFields();
				int i = 0;
				java.util.Iterator<String> it = form.getFields().keySet().iterator();
				while (it.hasNext()) {
					String name = it.next().toString();
					form.setField(name, data[i++]);
				}
				stamper.setFormFlattening(true);
				// 如果为false那么生成的PDF文件还能编辑，一定要设为true
				stamper.close();

				Document doc = new Document();
				PdfCopy copy = new PdfCopy(doc, out);
				doc.open();
				PdfImportedPage importPage = 
						copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
				copy.addPage(importPage);
				doc.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 
		 *设置字体
		 * @param size
		 * @return 
		 * @return Font
		 * @author llzhu
		 * @date 2018年1月2日下午4:27:16
		 */
		public static Font getRomanFont(){
			BaseFont bf_times;
			try {
				bf_times = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1252", false);
				 return new Font(bf_times, 11, Font.NORMAL);
			} catch (Exception e) {
				return null;
			}
		  }
		
		/**
		 * 
		 * roman格式cell
		 * @param val
		 * @param cols
		 * @return 
		 * @return PdfPCell
		 * @author llzhu
		 * @date 2018年1月3日下午2:54:26
		 */
		public static PdfPCell createRomanCell(String val,int cols){
			  Font roman = null;
			try {
				roman = PdfUtil.getRomanFont();
			} catch (Exception e) {
				return null;
			}
			if(null==val||"".equals(val)){
				val=" ";
			}
			  PdfPCell cell = new PdfPCell(
					  new Paragraph(val,roman));
			  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			  if(cols>1){
				  cell.setColspan(cols);
			  }
			  cell.setLeading(3, 1);
			  cell.setMinimumHeight(17f);
			  return cell;
		  }
		
		  /**  
			* @Title: createValCell 
			* @author 代祯山  
			* @Description:创建用于填充数据的row
			* @param val 要填充的值
			* @return
			*/
			public static PdfPCell createSetBorderCell(String val,int whichBordera,int cols) {
					PdfPCell cell = createOneRowAsOneCell( val,cols);
					PdfUtil.notSetBorder(cell, whichBordera);
				  return cell;
			  }
	
	public static PdfPTable getTable(ZyhResumeBase base,List<ZyhResumeWork> worklist,
			List<ZyhResumeEducation> edulist,
			List<ZyhResumeIntention> intlist,List<ZyhResumeSpeciality> spelist) throws Exception{
		String headerName="个人简历";
		Font font = PdfUtil.getChineseFont();
		Font headerFont= PdfUtil.getChineseFont1(15);
		Font titleFont= PdfUtil.getChineseFont1(12);
		PdfPTable table  = new PdfPTable(new float[]{1f});//列数
		PdfPCell cell = new PdfPCell(new Paragraph(headerName,headerFont));
		cell.setBorder(0);
		cell.setMinimumHeight(30f);
		PdfUtil.setVHBothCenter(cell);
		table.addCell(cell);
		
		PdfPCell baseinfo= new PdfPCell(new Paragraph("基本信息",titleFont));
		baseinfo.setBorder(Rectangle.BOTTOM);
		baseinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
		baseinfo.setVerticalAlignment(Element.ALIGN_BOTTOM);
		baseinfo.setMinimumHeight(23f);
		table.addCell(baseinfo);
		
		String workstate = "";
		if ("0".equals(base.getWorkstate())) {
			workstate = "在职";
		}else if ("1".equals(base.getWorkstate())) {
			workstate = "离职";
		}else if ("3".equals(base.getWorkstate())) {
			workstate = "考虑换工作";
		}else {
			workstate = "未知";
		}
		PdfPCell base1= new PdfPCell(new Paragraph(base.getName()+" | "+base.getSex()
				+" | "+DateUtil.subYears(new Date(), base.getBirthday())+"岁 | "+workstate,font));
		base1.setHorizontalAlignment(Element.ALIGN_LEFT);
		base1.setVerticalAlignment(Element.ALIGN_CENTER);
		base1.setMinimumHeight(18f);
		base1.setBorder(0);
		table.addCell(base1);
		
		int year = 0;
		if(base.getSoldierdate().contains(",")){
			String[] date = base.getSoldierdate().split(",");
			year = Integer.valueOf(date[1].substring(0, 4))-Integer.valueOf(date[0].substring(0, 4));
		}
		PdfPCell base2= new PdfPCell(new Paragraph(base.getBirthcity()+" | "+year
				+"年当兵经验 | "+DateUtil.subYears(new Date(),base.getWorkdate())+"年工作经验",font));
		base2.setHorizontalAlignment(Element.ALIGN_LEFT);
		base2.setVerticalAlignment(Element.ALIGN_CENTER);
		base2.setMinimumHeight(18f);
		base2.setBorder(0);
		table.addCell(base2);
		
		PdfPCell base3= new PdfPCell(new Paragraph("退伍编号："+base.getSoldierno(),font));
		base3.setHorizontalAlignment(Element.ALIGN_LEFT);
		base3.setVerticalAlignment(Element.ALIGN_CENTER);
		base3.setMinimumHeight(18f);
		base3.setBorder(0);
		table.addCell(base3);
		
		PdfPCell base4= new PdfPCell(new Paragraph("部队专业："+base.getBdzy(),font));
		base4.setHorizontalAlignment(Element.ALIGN_LEFT);
		base4.setVerticalAlignment(Element.ALIGN_CENTER);
		base4.setMinimumHeight(18f);
		base4.setBorder(0);
		table.addCell(base4);
		
		PdfPCell base5= new PdfPCell(new Paragraph("电话："+base.getPhone(),font));
		base5.setHorizontalAlignment(Element.ALIGN_LEFT);
		base5.setVerticalAlignment(Element.ALIGN_CENTER);
		base5.setMinimumHeight(18f);
		base5.setBorder(Rectangle.BOTTOM);
		table.addCell(base5);
		
		PdfPCell workinfo= new PdfPCell(new Paragraph("工作经验",titleFont));
		workinfo.setBorder(Rectangle.BOTTOM);
		workinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
		workinfo.setVerticalAlignment(Element.ALIGN_BOTTOM);
		workinfo.setMinimumHeight(23f);
		table.addCell(workinfo);
		
		if(null!=worklist && worklist.size()>0){
			for (int i = 0; i < worklist.size(); i++) {
				ZyhResumeWork work = worklist.get(i);
				PdfPCell info= new PdfPCell(new Paragraph(work.getWorktime().replaceAll("-", "/").replaceAll(",", "-"),font));
				info.setHorizontalAlignment(Element.ALIGN_LEFT);
				info.setVerticalAlignment(Element.ALIGN_CENTER);
				info.setMinimumHeight(18f);
				info.setBorder(0);
				table.addCell(info);
				
				PdfPCell info1= new PdfPCell(new Paragraph(work.getCompany(),font));
				info1.setHorizontalAlignment(Element.ALIGN_LEFT);
				info1.setVerticalAlignment(Element.ALIGN_CENTER);
				info1.setMinimumHeight(18f);
				info1.setBorder(0);
				table.addCell(info1);
				
				PdfPCell info2= new PdfPCell(new Paragraph(work.getPosition(),font));
				info2.setHorizontalAlignment(Element.ALIGN_LEFT);
				info2.setVerticalAlignment(Element.ALIGN_CENTER);
				info2.setMinimumHeight(18f);
				info2.setBorder(0);
				table.addCell(info2);
				
				PdfPCell info3= new PdfPCell(new Paragraph("工作描述："+work.getDesct(),font));
				info3.setHorizontalAlignment(Element.ALIGN_LEFT);
				info3.setVerticalAlignment(Element.ALIGN_CENTER);
				info3.setMinimumHeight(18f);
				info3.setBorder(Rectangle.BOTTOM);
				table.addCell(info3);
			}
		}
		
		PdfPCell eduinfo= new PdfPCell(new Paragraph("教育经验",titleFont));
		eduinfo.setBorder(Rectangle.BOTTOM);
		eduinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
		eduinfo.setVerticalAlignment(Element.ALIGN_BOTTOM);
		eduinfo.setMinimumHeight(23f);
		table.addCell(eduinfo);
		
		if(null!=edulist && edulist.size()>0){
			for (int i = 0; i < edulist.size(); i++) {
				ZyhResumeEducation edu = edulist.get(i);
				PdfPCell info= new PdfPCell(new Paragraph(edu.getEdtime().replaceAll("-", "/").replaceAll(",", "-"),font));
				info.setHorizontalAlignment(Element.ALIGN_LEFT);
				info.setVerticalAlignment(Element.ALIGN_CENTER);
				info.setMinimumHeight(18f);
				info.setBorder(0);
				table.addCell(info);
				
				PdfPCell info1= new PdfPCell(new Paragraph(edu.getSchool(),font));
				info1.setHorizontalAlignment(Element.ALIGN_LEFT);
				info1.setVerticalAlignment(Element.ALIGN_CENTER);
				info1.setMinimumHeight(18f);
				info1.setBorder(0);
				table.addCell(info1);
				
				PdfPCell info2= new PdfPCell(new Paragraph(edu.getMajor(),font));
				info2.setHorizontalAlignment(Element.ALIGN_LEFT);
				info2.setVerticalAlignment(Element.ALIGN_CENTER);
				info2.setMinimumHeight(18f);
				info2.setBorder(Rectangle.BOTTOM);
				table.addCell(info2);
			}
		}
		
		PdfPCell intinfo= new PdfPCell(new Paragraph("期望工作",titleFont));
		intinfo.setBorder(Rectangle.BOTTOM);
		intinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
		intinfo.setVerticalAlignment(Element.ALIGN_BOTTOM);
		intinfo.setMinimumHeight(23f);
		table.addCell(intinfo);
		
		if(null!=intlist && intlist.size()>0){
			for (int i = 0; i < intlist.size(); i++) {
				ZyhResumeIntention inte = intlist.get(i);
				PdfPCell info= new PdfPCell(new Paragraph(inte.getPosition(),font));
				info.setHorizontalAlignment(Element.ALIGN_LEFT);
				info.setVerticalAlignment(Element.ALIGN_CENTER);
				info.setMinimumHeight(18f);
				info.setBorder(0);
				table.addCell(info);
				
				PdfPCell info1= new PdfPCell(new Paragraph(inte.getWorkcity()+"  "+inte.getType()+"  "+inte.getExpectation(),font));
				info1.setHorizontalAlignment(Element.ALIGN_LEFT);
				info1.setVerticalAlignment(Element.ALIGN_CENTER);
				info1.setMinimumHeight(18f);
				info1.setBorder(Rectangle.BOTTOM);
				table.addCell(info1);
				
			}
		}
		
		PdfPCell speinfo= new PdfPCell(new Paragraph("技能特长",titleFont));
		speinfo.setBorder(Rectangle.BOTTOM);
		speinfo.setHorizontalAlignment(Element.ALIGN_LEFT);
		speinfo.setVerticalAlignment(Element.ALIGN_BOTTOM);
		speinfo.setMinimumHeight(23f);
		table.addCell(speinfo);
		StringBuilder sbd = new StringBuilder();
		if(null!=spelist && spelist.size()>0){
			for (int i = 0; i < spelist.size(); i++) {
				ZyhResumeSpeciality spe = spelist.get(i);
				sbd.append(spe.getCertificate()+"  ");
			}
			PdfPCell info1= new PdfPCell(new Paragraph(sbd.toString(),font));
			info1.setHorizontalAlignment(Element.ALIGN_LEFT);
			info1.setVerticalAlignment(Element.ALIGN_CENTER);
			info1.setMinimumHeight(18f);
			info1.setBorder(Rectangle.BOTTOM);
			table.addCell(info1);
		}
		
		
		table.setWidthPercentage(80);
		return table;
	}
	
}
