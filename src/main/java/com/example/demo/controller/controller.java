package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.playstatus;
import com.example.demo.entity.Event;
import com.example.demo.entity.account;
import com.example.demo.entity.eventwraper;
import com.example.demo.entity.messagee;
import com.example.demo.entity.replymessage;
import com.example.demo.entity.status;
import com.example.demo.entity.playplannlist;
import com.example.demo.repository.repository;
import com.example.demo.repository.repositoryplay;
import com.example.demo.repository.repositoryplaystatus;
import com.example.demo.repository.repositorystatus;
import com.example.service.AePlayWave;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.ReplyMessage;
//import com.example.demo.repository.repository;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.example.demo.service.appservice;
//@RestController
@Controller
@RequestMapping("/g")
public class controller {

	
	@Autowired
	appservice appservice;
	@Autowired
	repository rep;
	@Autowired
	repositorystatus rep2;
	@Autowired
	repositoryplay rep3;
	@Autowired
	repositoryplaystatus rep4;
	@Autowired
	playstatus playstatus;
	
//	@RequestMapping("/greeting")
//  public String hello(@RequestBody String h) {
//		String kk=null;
//		System.out.println(h.indexOf("\"text\":\""+8)+"...."+h.indexOf("\"}}],"));
//System.out.println(kk=h.substring(h.indexOf(",\"text\"")+9, h.indexOf("\"}}],")));
////rep.sett(kk);
//    return("dd"); // 根據view resolver mapping至hello.jsp
//  }
//	
	@RequestMapping(value="/gg")
	  public void hello2(@RequestBody eventwraper events) throws IOException, ExecutionException {	
//	String gg=null;
//	  LineMessagingClient client = LineMessagingClient.builder("n4xYgKh1Gi9aQSnL/UoSSRklKeJFh4Ipn2EkV10LjEX9MdQSMdg9zAbbH+77+jzb2L2YqX9o1lPoWTSDUdsVYdNKomqHZu7p6emYii1XoFNlNMXu1wkc7Mn09Xon3vEpeofNJgoJcz1+2WcbCSug2gdB04t89/1O/w1cDnyilFU=").build();
//	  SimpleDateFormat smd =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
//	  Date date =new Date();
//	//  System.out.println();
//	  String nowtime=smd.format(date);
//	 int qq2=1+(int)( Math.random()*100);
//	gg=events.getEvents().get(0).getReplyToken();
//
//	String ggf;
//	ggf=events.getEvents().get(0).getMessage().getText();
//	String replymsg="";
//	String statusnow="";
// 	statusnow=rep2.status();
//
// 
//  // String [] uu= {"寶貝我最愛妳了","綸綸是我的公主","綸綸是我的女神",events.getEvents().get(0).getMessage().getText(),"沒有不學妳，笨笨"};
//   String [] uu1= {"真的嗎??","到底是誰在搞!","無此資料","不知道怎麼回答",events.getEvents().get(0).getMessage().getText()
//		   ,events.getEvents().get(0).getMessage().getText(),"姿蓉氣質又優雅","好喔"
//		   ,"Ivy來單挑R","怎麼會這樣","別走~"
//   
//   };
//  
//    
//    
//    if((ggf.indexOf("愛你")!=-1)) {
//    	
//    	replymsg="0~999選一個數字";
//    	rep2.sett("4");
//    }
//   else if (statusnow.equals("0"))
//{
//	//沒事狀太
//	   if((ggf.indexOf("畢業")!=-1)||ggf.indexOf("開始")!=-1)
//	   {
////		   int ii=(int)( Math.random()*100);
////		   if(ii>33 &&ii<67) {
////			  replymsg="開始問答闖關瞜!!第一題，妳知道一年中總共有幾個情人節可以慶祝呢?(若要退出請打離開)";
////		   }else if (ii<=33) {
////		   replymsg="開始問答闖關瞜!!第一題，全世界中過最多情人節的是哪個國家?(若要退出請打離開)";
////		   }else {
////			   replymsg="開始問答闖關瞜!!第一題，情人節其實是在公元496年開始訂立的，那情人節的前身是甚麼節日呢?(若要退出請打離開)";
////		   }
//		   replymsg="為了拿到畢業證書，請通過以下試煉~0-99選一個數字";
//		   rep2.sett("1");
//	   }else if ((ggf.indexOf("誇張")!=-1)||(ggf.indexOf("哪有")!=-1)||(ggf.indexOf("啥鬼")!=-1)||(ggf.indexOf("真的")!=-1)||(ggf.indexOf("最好是")!=-1))
//	   {
//		   replymsg="真的喔";
//	   }else if ((ggf.indexOf("為什麼")!=-1))
//	   {
//		   replymsg="因為喜歡妳(???";
//	   }else if ((ggf.indexOf("出去玩21321321")!=-1))
//	   {
//		   replymsg="https://mw.herokuapp.com/g/date";
//	   }else if ((ggf.indexOf("取消")!=-1))
//	   {
//		   replymsg="不能取消喔";
//	   }else if ((ggf.indexOf("謝謝")!=-1))
//	   {
//		   replymsg="不客氣";
//	   }else if ((ggf.indexOf("開始")!=-1))
//	   {
//		   replymsg="有點聰明";
//	   }else if ((ggf.indexOf("想妳")!=-1)||(ggf.indexOf("想你")!=-1))
//	   {
//		   replymsg="我也想妳了";
//	   }else if ((ggf.indexOf("..")!=-1)&&(ggf.indexOf("吼")!=-1))
//	   {
//		   replymsg="機器人太笨了嗎";
//	   }else if((ggf.indexOf("?")!=-1))
//	   {
//		   replymsg="怎麼了??";
//	   }else if((ggf.indexOf("天氣")!=-1))
//	   {
//		   replymsg="之後再新增這功能喔";
//	   }else if ((ggf.indexOf("是誰")!=-1)||(ggf.indexOf("是什")!=-1)||(ggf.indexOf("這啥")!=-1)||(ggf.indexOf("這什麼")!=-1))
//	   {
//		   replymsg="我是life_devil_bot出生於20220618，不知道弄了什麼奇怪的東東";
//	   }else if ((ggf.indexOf("遊戲")!=-1)||(ggf.indexOf("目標")!=-1))
//	   {
//		   replymsg="請打'畢業'兩個字";
//	   }else if ((ggf.indexOf("隱藏")!=-1))
//	   {
//		   replymsg="隱藏模式需要不一樣的感受";
//	   }else if ((ggf.indexOf("不要")!=-1))
//	   {
//		   replymsg="QQ";
//	   }else if ((ggf.indexOf("不理你")!=-1))
//	   {
//		   replymsg="https://ivyyyyyyyyyyyyyyyy.herokuapp.com/ggg/playplayplay";
//	   }else if ((ggf.indexOf("照顧")!=-1))
//	   {
//		   replymsg="加油好嗎";
//	   }else if ((ggf.indexOf("不理")!=-1))
//	   {
//		   replymsg="可以不理我，不要不理life吶";
//	   }else if ((ggf.indexOf("可愛")!=-1)||(ggf.indexOf("笨")!=-1)||(ggf.indexOf("87")!=-1))
//	   {
//		   replymsg="Ivy聰明又可愛";
//	   }else if ((ggf.indexOf("起床")!=-1)||(ggf.indexOf("早")!=-1))
//	   {
//		   replymsg="早安~";
//	   }else if ((ggf.indexOf("雲林")!=-1))
//	   {
//		   replymsg="雲林是個中部的好地方";
//	   }else if ((ggf.indexOf("住哪")!=-1)||(ggf.indexOf("住在")!=-1))
//	   {
//		   replymsg="我被部屬在雲端";
//	   }else if ((ggf.indexOf("無聊")!=-1)||(ggf.indexOf("看")!=-1))
//	   {
//		   replymsg="來打傳說R還是玩姿蓉大冒險https://ivyyyyyyyyyyyyyyyy.herokuapp.com/ggg/playplayplay";
//	   }else if ((ggf.indexOf("怎麼半")!=-1)||(ggf.indexOf("怎麼辦")!=-1))
//	   {
//		   replymsg="下雨天了怎麼辦 ";
//	   }else if ((ggf.indexOf("時間")!=-1)||(ggf.indexOf("今天")!=-1))
//	   {
//		   replymsg="現在的時間是"+nowtime;
//	   }else if ((ggf.indexOf("Ivy")!=-1))
//	   {
//		   replymsg="Ivy氣質出眾";
//	   }else if ((ggf.indexOf("睡覺")!=-1)||(ggf.indexOf("掰掰")!=-1))
//	   {
//		   replymsg="Ivy晚安";
//	   }else if ((ggf.indexOf("聊天")!=-1))
//	   {
//		   replymsg="我不善於聊天";
//	   }else if ((ggf.indexOf("好煩")!=-1))
//	   {
//		   replymsg="吃甜點就不煩了";
//	   }else if ((ggf.indexOf("生氣")!=-1))
//	   {
//		   replymsg="不要生氣";
//	   }else if ((ggf.indexOf("吃飯")!=-1))
//	   {
//		   replymsg="我只需要充電";
//	   }else if ((ggf.indexOf("運動")!=-1))
//	   {
//		   replymsg="來打羽球R";
//	   }else if ((ggf.indexOf("學我")!=-1))
//	   {
//		   replymsg="太調皮了";
//	   }else if ((ggf.indexOf("妳好")!=-1)||(ggf.indexOf("你好")!=-1)||(ggf.indexOf("嗨")!=-1))
//	   {
//		   replymsg="Hello";
//	   }else if ((ggf.indexOf("好慢")!=-1))
//	   {
//		   replymsg="免費的資料庫真的慢";
//	   }else if ((ggf.indexOf("走開")!=-1))
//	   {
//		   
//		   
//		   replymsg="妳才是走開的那個QQ";
//	   }else {
//		   
//		   
//		   int ii=(int)( Math.random()*11);
//		   replymsg=uu1[ii];
//	   }
//	   
//	   
//	   
//	   
//	   
//	   
//	
//}else if(statusnow.equals("1"))
//{
//	
//	if((ggf.indexOf("離開")!=-1))
//	   {
//		replymsg="已經離開問答狀態";	
//		 rep2.sett("0");
//	   }else if ((ggf.indexOf("24")!=-1)||(ggf.indexOf("25")!=-1)||(ggf.indexOf("26")!=-1))
//	   {
//		   
//		   int ii=(int)( Math.random()*100);
//		   if(ii>500) {
//		   replymsg="nice Ivy，請輸入3位數密碼001~999";
//		   rep2.sett("2");
//		   }else {
//		   replymsg="好聰明的Ivy，請輸入3位數密碼001~999";
//		   rep2.sett("2");
//		   }
//	   }else {
//		  
//		   if(Integer.parseInt(ggf)>26) {
//		   replymsg="Ivy有這麼老嗎??";
//		     }else if (Integer.parseInt(ggf)<=23) {
//		    	 replymsg="答錯~未成年母湯喔";
//		     }
//	   }
//	//question1
//}
//else if (statusnow.equals("2")){
//	if((ggf.indexOf("離開")!=-1))
//	   {
//		replymsg="已經離開問答狀態";	
//		 rep2.sett("0");
//	   }else if ((ggf.indexOf("622")!=-1))
//	   {
//		   
//	
//		   replymsg="答對了呢!開始進入今天的主題吧>>https://ivyyyyyyyyyyyyyyyy.herokuapp.com/g/restart";
//		
//		   rep2.sett("0");
//		   
//	   }else {
//		   
//		   
//		   int ii=(int)( Math.random()*100);
//		   if(ii>33 &&ii<67) {
//			   replymsg="答錯~這是妳的最後一天嗎";
//			     }else if (ii<=33) {
//			    	 replymsg="再試試看~妳的結業日阿...";
//			     }else {
//			    	 replymsg="不太對喔，3個數字加起來等於10(第一個數字是6)";
//			     }
//	   }
//}
////else if (statusnow.equals("3")){
////	//question3 給卡片
////	if((ggf.indexOf("離開")!=-1))
////	   {
////		replymsg="已經離開問答狀態";	
////		 rep2.sett("0");
////	   }else if (ggf.length()>6)
////	   {
////		   
////		
////			   replymsg="恭喜完成尬到不行問答(問答每次應該都會有點不一樣)~        Ivy，祝妳情人節快樂，雖然這個bot一點都不ai，而且好像還蠻蠢的"
////			   		+ "  ，不過如果妳有從中得到那麼一丁點的樂趣  (對我而言就算值得了吧@@ 這樣我是不是沒顧慮到妳的感受XD)。    其實這個有隱藏版的吶，目的是為了拿到第二塊拼圖"+
////			   "，只是可能要腦洞大開才有辦法找到XDDD。 (或是隨便問些問題搞不好會有線索)";
////			   rep2.sett("0");
////		   
////	   }else {
////		   int ii=(int)( Math.random()*100);
////		   if(ii>33 &&ii<67) {
////			   replymsg="字數不足喔~(結束問答請打離開)";
////			     }else if (ii<=33) {
////			    	 replymsg= "字數不足喔再試試看~(結束問答請打離開)";
////			     }else {
////			    	 replymsg="字數不足喔try again~(結束問答請打離開)";
////			     }
////	   }
////}
//else if (statusnow.equals("4")){
//	if ((ggf.indexOf("520")!=-1))
//	{
//		replymsg="真的假的~只好跟妳告白了，我喜歡妳";
//		 rep2.sett("0");
//	}else {
//		replymsg="很可惜答錯了，已離開隱藏模式";
//		 rep2.sett("0");
//	}
//	
//	//回答4
//  }
////	else if (statusnow.equals("5")){
////	//回答32
////	if ((ggf.indexOf("32")!=-1))
////	{
////		replymsg="我們名字的筆畫都是32。 下一題000~999選一組數字";
////		 rep2.sett("6");
////	}else {
////		replymsg="很可惜答錯了，已離開隱藏模式";
////		 rep2.sett("0");
////	}
////}else if (statusnow.equals("6")){
////	//回答520
////	if ((ggf.indexOf("520")!=-1))
////	{
////		replymsg="答案是520 520 520。  最後一題0000~9999選一組數字";
////		 rep2.sett("7");
////	}else {
////		replymsg="很可惜答錯了，已離開隱藏模式";
////		 rep2.sett("0");
////	}
////}else if (statusnow.equals("7")){
////	//回答0210
////	if ((ggf.indexOf("0210")!=-1))
////	{
////		replymsg="答對了，恭喜完成隱藏關卡!!!(有沒有覺得cp值很低)   其實我也不確定當妳看到這些的時候是幾月的事了，也許是"
////				+ "2月底、也許是3月或是根本沒有機會也說不定XD  不知道妳是否還記得在2月的時候妳說我有修過聊天學，好像蠻會找話題的。"
////				+ "@@現在看到有沒有覺得根本不是這麼回是齁，會想找話題其實只是因為不希望妳就這樣消失而已XDD，我不希望未來的我會回想當初因為"
////				+ "少做點了甚麼而感到後悔~，我的生活圈很小大概就像把自己框在一個圈圈裏面，一大段時間大概只會跟一個人聊天，"
////				+ "所以當然也沒有其他人會這樣跟我說瞜。 關卡的拼圖在這~ Second puzzle is LOVE.";
////		 rep2.sett("0");
////	}else {
////		replymsg="很可惜答錯了，已離開隱藏模式";
////		 rep2.sett("0");
////	}
////	
////}
//
//   
//   
//   
//   
//    
//    
//   //replymsg=statusnow;
//   
//   
//    TextMessage textMessage=null;
//    
//    
//
//    
//    
//    textMessage = new TextMessage(replymsg);
// 
//    
//    
//	final ReplyMessage replyMessage = new ReplyMessage( gg,textMessage);
//
//	BotApiResponse botApiResponse=null;
//	try {
//	    botApiResponse = client.replyMessage(replyMessage).get();
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	 
//	}
//
//	//System.out.println(botApiResponse);
//   
////	rep.sett("123",events.getEvents().get(0).getSource().getUserId());
//	  rep.sett(ggf,textMessage.getText());
//  
   
//   jsonString ="{\"replyToken\":\""+gg+"\",\"message\":[{\"type\":\"text\",\"text\":\"hihihihihi\"},{\"type\":\"text\",\"text\":\"ddd\"}]}";
   
//   System.out.println(jsonString);
//   sentpost(jsonString);
	//    return(gg); // 根據view resolver mapping至hello.jsp
	  }
		
	
	
	@RequestMapping("/yulun")
  public String hello2(@RequestBody String ff) {
		System.out.println(ff); 
		return(rep.findAll().get(0).getPas());
		 
  // 根據view resolver mapping至hello.jsp
  }
	


	@RequestMapping("/card2")
	//@ResponseBody
	public String card2(HttpServletRequest request,Model model) {
		
		   

	    	
	     
	  
	        return "succes4";  // 早上5:20到晚上17:20顯示succes5

		
	}
	
	@RequestMapping("/testinng")
	//@ResponseBody
	public String testing2(Model model) {
		
		SimpleDateFormat sfd =new SimpleDateFormat("yyyy-MM-dd");
		String aa = sfd.format(new Date());
		System.out.println(aa);
		model.addAttribute("name11", aa);
		model.addAttribute("name113", " ");
		
		return "date1";
	}
	
	
	@RequestMapping("/random")
	//@ResponseBody
	public String testin323(Model model) {
		
		SimpleDateFormat sfd =new SimpleDateFormat("yyyy-MM-dd");
		String aa = sfd.format(new Date());
	
		System.out.println(aa);
		model.addAttribute("name11", aa);
		model.addAttribute("name113", " ");

	
		return "date1";
	}
	
	
	@RequestMapping("/restart")
	//回到start orstart2
	public String testing2323(Model model) {
		
		rep4.updates1("0");
		rep4.updates2("");
		if (rep4.getstatus().getStatus3().equals("0"))
		{
			
			return "start1";
		}
		else {
		return "start";
		}
	}
	
	
	
	
	
	//指到起始date葉面
	@RequestMapping("/date")
	//@ResponseBody
	public String testing(Model model) {
		
		SimpleDateFormat sfd =new SimpleDateFormat("yyyy-MM-dd");
		String aa = sfd.format(new Date());
		System.out.println(aa);
		model.addAttribute("name11", aa);
		model.addAttribute("name113", " ");

		return "date1";
	}
	
	//案新增的功能
	@RequestMapping("/date2")
	//@ResponseBody
	public String testing2(HttpServletRequest request,Model model) throws ParseException {
		
		String  a,b,c,d,e; 
		SimpleDateFormat sfd2 =new SimpleDateFormat("yyyymmddhhmmss");
		String aa2 = sfd2.format(new Date());
		Date startDate=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
		b=request.getParameter("YourLocation");
		c=request.getParameter("dosomething");
		d=request.getParameter("txarea");
		SimpleDateFormat sfd =new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(a=sfd.format(startDate));
		System.out.println(b);	System.out.println(c);	System.out.println(d);
		
		rep3.sett(aa2, a, b, c, d,"1");
		
		
		model.addAttribute("name11", a);
		model.addAttribute("name113", "已新增成功");

		
		return "date1";
	}
	
	
	//總表的功能
	@RequestMapping("/date3")
	//@ResponseBody
	public String testing3(HttpServletRequest request,Model model) throws ParseException {
		
		String[]kk= {"text1","text2","text3","text4","text5","text6","text7","text8","text9"};
		List<playplannlist> playplanlist=new ArrayList<playplannlist>();
		playplanlist=rep3.ww();
	
		
		for(int i=0;i<playplanlist.size();i++)
		{
			model.addAttribute(kk[i],"日期: "+playplanlist.get(i).getDate()+"\n\n"+
		"要出發去:  "+playplanlist.get(i).getGo2()+"\n\n"+
					"intent:"+playplanlist.get(i).getHow()+"\n\n"+
		"MEMO :"+playplanlist.get(i).getMemo());
			
			
			
		}	
			
		return "datelist";
	}
	
	
	//沒法刪除按鈕
	@RequestMapping("/nocansle")
	public String testing222(HttpServletRequest request,Model model) throws ParseException {
		
		 rep.sett("nocansle","qq");
			
		return "datex";
	}
	@RequestMapping("/index")
	public String helloThymeleaf(Model model){
		//model.addAttribute("name11", "Ivy");
		
		
     		 if (rep2.status()!=null&&Integer.valueOf(rep2.status())>50000)
     		 {
     			return "start4";
     		 }else if (rep2.status()!=null&&Integer.valueOf(rep2.status())>20000)
     		 {
     			return "start3";
     		 }else if (rep2.status()!=null&&Integer.valueOf(rep2.status())>10000)
     		 {
     			return "start2";
     		 }
		
		return "start";
	}
	
	
	
	@RequestMapping("/song")
	//@ResponseBody
	public String song(HttpServletRequest request,Model model) {
		
//	
//		rep4.updates1("0");
//		rep4.updates2("");
////	playstatus=rep4.getstatus();
//		model.addAttribute("nowrate", "0/5");
//		model.addAttribute("errormsg", "question1");
//		
//		int qqw=(int)(Math.random()*17);
//		if(qqw==1||qqw==2||qqw==0)
//		{
//			qqw=3;
//		}else if(qqw==3||qqw==4||qqw==5)
//		{
//			qqw=4;
//		}else if (qqw==6||qqw==7||qqw==8)
//		{
//			qqw=7;
//		}else if (qqw==9||qqw==10||qqw==11)
//		{
//			qqw=8;
//		}else if (qqw==12||qqw==13||qqw==14)
//		{
//			qqw=6;
//		}else if (qqw==15||qqw==16)
//		{
//			qqw=1;
//		}else {}
		
		return "succes";
	}
	
	
	
	
	@RequestMapping("/card")
	//@ResponseBody
	public String card(HttpServletRequest request,Model model) {
		
		   
	    // 設定台灣時區
	    ZoneId taiwanZone = ZoneId.of("Asia/Taipei");
	    LocalTime now = LocalTime.now(taiwanZone);
	    
	    // 定義時間範圍：早上5:20到晚上17:20 (5:20 PM)
	    LocalTime startTime = LocalTime.of(5, 20);  // 05:20
	    LocalTime endTime = LocalTime.of(17, 20);   // 17:20
	    
	    // 判斷當前時間是否在指定範圍內
	    if (now.isAfter(startTime) && now.isBefore(endTime)) {
	    	
	     
	  
	        return "succes5";  // 早上5:20到晚上17:20顯示succes5
	    } else {
	    	   
            // 在背景播放音樂，不阻塞頁面返回
       
	        return "succes6";  // 其他時間顯示succes4
	    }
		
	}
	
	
	@RequestMapping("/song2")
	//@ResponseBody
	public String song2(HttpServletRequest request,Model model) {
		
//	
//		rep4.updates1("0");
//		rep4.updates2("");
////	playstatus=rep4.getstatus();
//		model.addAttribute("nowrate", "0/5");
//		model.addAttribute("errormsg", "question1");
//		
//		int qqw=(int)(Math.random()*17);
//		if(qqw==1||qqw==2||qqw==0)
//		{
//			qqw=3;
//		}else if(qqw==3||qqw==4||qqw==5)
//		{
//			qqw=4;
//		}else if (qqw==6||qqw==7||qqw==8)
//		{
//			qqw=7;
//		}else if (qqw==9||qqw==10||qqw==11)
//		{
//			qqw=8;
//		}else if (qqw==12||qqw==13||qqw==14)
//		{
//			qqw=6;
//		}else if (qqw==15||qqw==16)
//		{
//			qqw=1;
//		}else {}
		
		return "succes2";
	}
	
	@RequestMapping("/song3")
	//@ResponseBody
	public String song3(HttpServletRequest request,Model model) {
		
//	
//		rep4.updates1("0");
//		rep4.updates2("");
////	playstatus=rep4.getstatus();
//		model.addAttribute("nowrate", "0/5");
//		model.addAttribute("errormsg", "question1");
//		
//		int qqw=(int)(Math.random()*17);
//		if(qqw==1||qqw==2||qqw==0)
//		{
//			qqw=3;
//		}else if(qqw==3||qqw==4||qqw==5)
//		{
//			qqw=4;
//		}else if (qqw==6||qqw==7||qqw==8)
//		{
//			qqw=7;
//		}else if (qqw==9||qqw==10||qqw==11)
//		{
//			qqw=8;
//		}else if (qqw==12||qqw==13||qqw==14)
//		{
//			qqw=6;
//		}else if (qqw==15||qqw==16)
//		{
//			qqw=1;
//		}else {}
		
		return "succes3";
	}
	
	@RequestMapping("/valid")
	//@ResponseBody
	public String Valid(HttpServletRequest request,Model model) {
		//Model model=null;
	String accountt =request.getParameter("name");
	
String password=   request.getParameter("password");

rep.sett(accountt,password);
	
String result = appservice.login(accountt, password);

if (result.equals("yes"))
{
	playstatus=rep4.getstatus();
	if (playstatus.getStatus3().equals("0"))
	{ 
		return "start1";}
	else {
		
	return "start";}
	
	
}else 
{
	model.addAttribute("name11", result);
}
	return "index"; 
	
//	
	
	
	
	}
	
	
	@RequestMapping("/y226")
	@ResponseBody // 使用 @GetMapping，對應 GET 請求
    public String tt4() {
    System.out.println("test");
    rep2.sett("1");
    return "dd";
    }
	
	
	@RequestMapping("/y227")
	@ResponseBody // 使用 @GetMapping，對應 GET 請求
    public String tt7() {
    System.out.println("test");
    rep2.sett("100000");
    return "dd";
    }
	
	@RequestMapping("/y")
	@ResponseBody
	  public List<account> ss2() {
			
		  List<account> ww=new ArrayList<account>();
		  ww=rep.ww();
		  System.out.println(ww.size());
		  return ww;
			//return(rep.findAll().get(0).getPas());
			 
	  // 根據view resolver mapping至hello.jsp
	  }
	  
		@RequestMapping("/test3")
		@ResponseBody
		  public String ss5() {
				
		
			  return "new";
				//return(rep.findAll().get(0).getPas());
				 
		  // 根據view resolver mapping至hello.jsp
		  }
	
	  
	  
	 //////////////////////////////////////////////////////////////////////////////
	  
		@RequestMapping("/y2")
		@ResponseBody
		  public List<status> ss3() {
				
			  List<status> ww=new ArrayList<status>();
			  ww=rep2.ww1();
			
			  return ww;
				//return(rep.findAll().get(0).getPas());
				 
		  // 根據view resolver mapping至hello.jsp
		  }
		  
			@RequestMapping("/y7")
			@ResponseBody
			  public String  ss4() throws IOException {
					
				
				
				 Document doc = Jsoup.connect("https://www.youtube.com/channel/UCyhTOPmMeUL4inFgjaA4QxA/videos").get();
				 // Document doc = Jsoup.connect(" https://www.youtube.com/user/vasthazy").get();
				    Elements links = doc.select("a[href]");
				    Elements imports = doc.select("link[href]");
				   //links.get(i).text().trim()
				    //links.get(i).attr("abs:href")+" "+
				    for (int i =0;i<links.size();i++)
				    {
				    	if (links.get(i).text().startsWith("好樂團"))
				    	{	System.out.println(links.get(i).text());
				    	System.out.println(links.get(i).attr("abs:href"));
				    }}
				  return doc.text();
					//return(rep.findAll().get(0).getPas());
					 
			  // 根據view resolver mapping至hello.jsp
			  }
	  
	  
	String qqw=null;
	
	
	
//	@RequestMapping("/try")
//  public String hello33( String ff) {
//		
//		
//	    LineMessagingClient client = LineMessagingClient.builder("siyTXOs4UvFs4axEaIzKNPwfKupC0vWU3gC0ij7+vCHtX5gDgHe/5L8uIBaYHj0/wYE0iLP0ibgCv7m83ZBxhI9t06UVMDlNe7qx8xs/SSMnLnF6FnVPES2aEJBrWpMEJKDxKy+rhKOWYeTRiYP7/QdB04t89/1O/w1cDnyilFU=").build();
//
//	    
//		//Uf9ab298ecf4fd9df1c8c048dabdcf924Ivy
//	    TextMessage textMessage = new TextMessage(ff);
//	    PushMessage pushMessage = new PushMessage(
//	            "Uc6b7fd1fbe5b8b979c52055709698fbb",
//	            textMessage);
//
//	     BotApiResponse botApiResponse=null;
//	    try {
//	        botApiResponse = client.pushMessage(pushMessage).get();
//	    } catch (InterruptedException | ExecutionException e) {
//	        e.printStackTrace();
//	      
//	    }
//
//	    System.out.println(botApiResponse);
//	return ff;
//
//	
//	   
//  }

	
	
	
	
//	
//	@RequestMapping("/try1")
//	  public String hello11223(@RequestBody eventwraper events) throws IOException, ExecutionException {	
//		String gg=null;
//		gg=events.getEvents().get(0).getReplyToken();
//		System.out.println("efef");
//		System.out.println(events.getEvents().get(0).getReplyToken());
//		System.out.println(gg=events.getEvents().get(0).getSource().getUserId());
//		qqw=gg;
//		String ggf;
//	   rep.sett(ggf=events.getEvents().get(0).getMessage().getText());
//	   
//
//	
//	    LineMessagingClient client = LineMessagingClient.builder("AYeucduzbLCNlLFM9KSL53gTya2WpONrZkB6PMc0TQ1MFYOmO1PP0hn0/JbTp6/Yn/JVEllpAp1F1ClZMELsCu1MCNquW0qobAxQzo2IIgt7F25ChEQ7CQUd8/G+0Uopxv75GP2a1+UMmM+WgVDghwdB04t89/1O/w1cDnyilFU=").build();
//
//	    
//	
//	    TextMessage textMessage = new TextMessage("hello");
//	    PushMessage pushMessage = new PushMessage(
//	            gg,
//	            textMessage);
//
//	     BotApiResponse botApiResponse=null;
//	    try {
//	        botApiResponse = client.pushMessage(pushMessage).get();
//	    } catch (InterruptedException | ExecutionException e) {
//	        e.printStackTrace();
//	      
//	    }
//
//	 
//	
//
//	    System.out.println(botApiResponse);
//	   
//	   
//	   
//	   
//	//   jsonString ="{\"replyToken\":\""+gg+"\",\"message\":[{\"type\":\"text\",\"text\":\"hihihihihi\"},{\"type\":\"text\",\"text\":\"ddd\"}]}";
//	   
//	//   System.out.println(jsonString);
//	//   sentpost(jsonString);
//		    return(gg); // 根據view resolver mapping至hello.jsp
//	  }

			
	
		
	
	private void sentpost(String message) 
	{
		
//		try {
//		 String accestoken="{Q4AFo5nfKYJ8MiHV4uIYVUAAQ668GXP3d7RNL3EtV7p0l6sHkC+mXrZgwIgvcMvTg8ddT90tNHV9eMZ0yaeT48/qDB96YEISC1grArA8S6XbLuLTqPuNo8Kb4rubULYrFr3QBqMSAfFI7UXolz/EbwdB04t89/1O/w1cDnyilFU=}";
//	        URL url= new URL("localhost:8080/g/yulun");//"https://api.line.me/v2/bot/message/reply");
//	        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//
//	        //添加请求头
//	        con.setRequestMethod("POST");
//	        con.setRequestProperty("Content-Type", "application/json");
//	        con.setRequestProperty("Authorization", "Bearer "+accestoken);
//	        con.setRequestProperty("client_secret","a525c635ec4c6f0b26fda36dbb787525");
//	        
//	        con.setDoInput(true);
//	        con.setDoOutput(true);
//
//	        //发送Post请求
//	 System.out.println("sentnttt");
//	        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//	        wr.writeBytes(message);
//	        wr.flush();
//	        wr.close();
//	        System.out.println(con.getContent().toString());
//	        
//	      	 System.out.println("sentntttover");
//		      System.out.println( con.getResponseCode()+"==="+con.getResponseMessage());
//		     
//		}catch (Exception r)
//		{
//			System.out.println(r.toString());
//			System.out.println(r.getMessage());
//		}
//	

	       
	}
}