package com.cjw.project.code.ctrl;

public class a121 {

	

/*
 * tAnnouncement_id 
 * 
    String id = request.getParameter("tAnnouncement_id");
	if(!ObjectUtil.isEmpty(id)) tAnnouncement.setId(String.valueOf(id));
    String titlle = request.getParameter("tAnnouncement_titlle");
	if(!ObjectUtil.isEmpty(titlle)) tAnnouncement.setTitlle(String.valueOf(titlle));
    String content = request.getParameter("tAnnouncement_content");
	if(!ObjectUtil.isEmpty(content)) tAnnouncement.setContent(String.valueOf(content));
    String pictureId = request.getParameter("tAnnouncement_pictureId");
	if(!ObjectUtil.isEmpty(pictureId)) tAnnouncement.setPictureId(String.valueOf(pictureId));
    String creatTime = request.getParameter("tAnnouncement_creatTime");
	if(!ObjectUtil.isEmpty(creatTime)) tAnnouncement.setCreatTime(Long.valueOf(creatTime));
    String state = request.getParameter("tAnnouncement_state");
	if(!ObjectUtil.isEmpty(state)) tAnnouncement.setState(String.valueOf(state));*/
	

 //   <!--- java 参数 -->tCommodity_id
/*       String id = request.getParameter("tCommodity_id");
		if(!ObjectUtil.isEmpty(id)) tCommodity.setId(String.valueOf(id));
       String name = request.getParameter("tCommodity_name");
		if(!ObjectUtil.isEmpty(name)) tCommodity.setName(String.valueOf(name));
       String category = request.getParameter("tCommodity_category");
		if(!ObjectUtil.isEmpty(category)) tCommodity.setCategory(String.valueOf(category));
       String info = request.getParameter("tCommodity_info");
		if(!ObjectUtil.isEmpty(info)) tCommodity.setInfo(String.valueOf(info));
       String pop = request.getParameter("tCommodity_pop");
		if(!ObjectUtil.isEmpty(pop)) tCommodity.setPop(Integer.valueOf(pop));
       String pictureId = request.getParameter("tCommodity_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) tCommodity.setPictureId(String.valueOf(pictureId));
       String price = request.getParameter("tCommodity_price");
		if(!ObjectUtil.isEmpty(price)) tCommodity.setPrice(Double.valueOf(price));
       String secprice = request.getParameter("tCommodity_secprice");
		if(!ObjectUtil.isEmpty(secprice)) tCommodity.setSecprice(Double.valueOf(secprice));
       String conditions = request.getParameter("tCommodity_conditions");
		if(!ObjectUtil.isEmpty(conditions)) tCommodity.setConditions(String.valueOf(conditions));
       String messageId = request.getParameter("tCommodity_messageId");
		if(!ObjectUtil.isEmpty(messageId)) tCommodity.setMessageId(String.valueOf(messageId));
       String num = request.getParameter("tCommodity_num");
		if(!ObjectUtil.isEmpty(num)) tCommodity.setNum(Integer.valueOf(num));
       String sellerId = request.getParameter("tCommodity_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) tCommodity.setSellerId(String.valueOf(sellerId));
       String buyerId = request.getParameter("tCommodity_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) tCommodity.setBuyerId(String.valueOf(buyerId));
       String creartTime = request.getParameter("tCommodity_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) tCommodity.setCreartTime(Long.valueOf(creartTime));
       String closingTime = request.getParameter("tCommodity_closingTime");
		if(!ObjectUtil.isEmpty(closingTime)) tCommodity.setClosingTime(Long.valueOf(closingTime));
       String state = request.getParameter("tCommodity_state");
		if(!ObjectUtil.isEmpty(state)) tCommodity.setState(String.valueOf(state));*/
/*	
 * tMessage_id
    <!--- java 参数 -->
    String id = request.getParameter("tMessage_id");
	if(!ObjectUtil.isEmpty(id)) tMessage.setId(String.valueOf(id));
    String ownerId = request.getParameter("tMessage_ownerId");
	if(!ObjectUtil.isEmpty(ownerId)) tMessage.setOwnerId(String.valueOf(ownerId));
    String ownerName = request.getParameter("tMessage_ownerName");
	if(!ObjectUtil.isEmpty(ownerName)) tMessage.setOwnerName(String.valueOf(ownerName));
    String passersbyId = request.getParameter("tMessage_passersbyId");
	if(!ObjectUtil.isEmpty(passersbyId)) tMessage.setPassersbyId(String.valueOf(passersbyId));
    String answerId = request.getParameter("tMessage_answerId");
	if(!ObjectUtil.isEmpty(answerId)) tMessage.setAnswerId(String.valueOf(answerId));
    String commodityId = request.getParameter("tMessage_commodityId");
	if(!ObjectUtil.isEmpty(commodityId)) tMessage.setCommodityId(String.valueOf(commodityId));
    String content = request.getParameter("tMessage_content");
	if(!ObjectUtil.isEmpty(content)) tMessage.setContent(String.valueOf(content));
    String time = request.getParameter("tMessage_time");
	if(!ObjectUtil.isEmpty(time)) tMessage.setTime(Long.valueOf(time));
    String passersbyName = request.getParameter("tMessage_passersbyName");
	if(!ObjectUtil.isEmpty(passersbyName)) tMessage.setPassersbyName(String.valueOf(passersbyName));*/
	
	/*tOrder_id
	 * 
     <!--- java 参数 -->
        String id = request.getParameter("tOrder_id");
		if(!ObjectUtil.isEmpty(id)) tOrder.setId(String.valueOf(id));
        String commodityId = request.getParameter("tOrder_commodityId");
		if(!ObjectUtil.isEmpty(commodityId)) tOrder.setCommodityId(String.valueOf(commodityId));
        String pictureId = request.getParameter("tOrder_pictureId");
		if(!ObjectUtil.isEmpty(pictureId)) tOrder.setPictureId(String.valueOf(pictureId));
        String price = request.getParameter("tOrder_price");
		if(!ObjectUtil.isEmpty(price)) tOrder.setPrice(Double.valueOf(price));
        String num = request.getParameter("tOrder_num");
		if(!ObjectUtil.isEmpty(num)) tOrder.setNum(Integer.valueOf(num));
        String sellerId = request.getParameter("tOrder_sellerId");
		if(!ObjectUtil.isEmpty(sellerId)) tOrder.setSellerId(String.valueOf(sellerId));
        String buyerId = request.getParameter("tOrder_buyerId");
		if(!ObjectUtil.isEmpty(buyerId)) tOrder.setBuyerId(String.valueOf(buyerId));
        String creartTime = request.getParameter("tOrder_creartTime");
		if(!ObjectUtil.isEmpty(creartTime)) tOrder.setCreartTime(Long.valueOf(creartTime));
        String payTime = request.getParameter("tOrder_payTime");
		if(!ObjectUtil.isEmpty(payTime)) tOrder.setPayTime(Long.valueOf(payTime));
        String state = request.getParameter("tOrder_state");
		if(!ObjectUtil.isEmpty(state)) tOrder.setState(String.valueOf(state));
        String address = request.getParameter("tOrder_address");
		if(!ObjectUtil.isEmpty(address)) tOrder.setAddress(String.valueOf(address));
        String isSign = request.getParameter("tOrder_isSign");
		if(!ObjectUtil.isEmpty(isSign)) tOrder.setIsSign(Integer.valueOf(isSign));
        String isPay = request.getParameter("tOrder_isPay");
		if(!ObjectUtil.isEmpty(isPay)) tOrder.setIsPay(Integer.valueOf(isPay));
        String logisticsCode = request.getParameter("tOrder_logisticsCode");
		if(!ObjectUtil.isEmpty(logisticsCode)) tOrder.setLogisticsCode(String.valueOf(logisticsCode));
*/
	
/*
	 <!--- java 参数 -->tUser_id
        String id = request.getParameter("tUser_id");
		if(!ObjectUtil.isEmpty(id)) tUser.setId(String.valueOf(id));
        String account = request.getParameter("tUser_account");
		if(!ObjectUtil.isEmpty(account)) tUser.setAccount(String.valueOf(account));
        String username = request.getParameter("tUser_username");
		if(!ObjectUtil.isEmpty(username)) tUser.setUsername(String.valueOf(username));
        String password = request.getParameter("tUser_password");
		if(!ObjectUtil.isEmpty(password)) tUser.setPassword(String.valueOf(password));
        String userEmail = request.getParameter("tUser_userEmail");
		if(!ObjectUtil.isEmpty(userEmail)) tUser.setUserEmail(String.valueOf(userEmail));
        String avatar = request.getParameter("tUser_avatar");
		if(!ObjectUtil.isEmpty(avatar)) tUser.setAvatar(String.valueOf(avatar));
        String tel = request.getParameter("tUser_tel");
		if(!ObjectUtil.isEmpty(tel)) tUser.setTel(String.valueOf(tel));
        String sex = request.getParameter("tUser_sex");
		if(!ObjectUtil.isEmpty(sex)) tUser.setSex(String.valueOf(sex));
        String school = request.getParameter("tUser_school");
		if(!ObjectUtil.isEmpty(school)) tUser.setSchool(String.valueOf(school));
        String address = request.getParameter("tUser_address");
		if(!ObjectUtil.isEmpty(address)) tUser.setAddress(String.valueOf(address));
        String creatTime = request.getParameter("tUser_creatTime");
		if(!ObjectUtil.isEmpty(creatTime)) tUser.setCreatTime(Long.valueOf(creatTime));
        String lastTime = request.getParameter("tUser_lastTime");
		if(!ObjectUtil.isEmpty(lastTime)) tUser.setLastTime(Long.valueOf(lastTime));
        String loginIp = request.getParameter("tUser_loginIp");
		if(!ObjectUtil.isEmpty(loginIp)) tUser.setLoginIp(String.valueOf(loginIp));
        String isAdmin = request.getParameter("tUser_isAdmin");
		if(!ObjectUtil.isEmpty(isAdmin)) tUser.setIsAdmin(Integer.valueOf(isAdmin));
        String state = request.getParameter("tUser_state");
		if(!ObjectUtil.isEmpty(state)) tUser.setState(Integer.valueOf(state));
        String lng = request.getParameter("tUser_lng");
		if(!ObjectUtil.isEmpty(lng)) tUser.setLng(Double.valueOf(lng));
        String lat = request.getParameter("tUser_lat");
		if(!ObjectUtil.isEmpty(lat)) tUser.setLat(Double.valueOf(lat));
        String qq = request.getParameter("tUser_qq");
		if(!ObjectUtil.isEmpty(qq)) tUser.setQq(String.valueOf(qq));
        String wechat = request.getParameter("tUser_wechat");
		if(!ObjectUtil.isEmpty(wechat)) tUser.setWechat(String.valueOf(wechat));
        String alipay = request.getParameter("tUser_alipay");
		if(!ObjectUtil.isEmpty(alipay)) tUser.setAlipay(String.valueOf(alipay));

*/

/*
 * 
 * 
 * ModelAndView mv = new ModelAndView();
		List<testPO> a = testdao.queryinhtime();
		if (a.size()>10) {
			mv.setViewName("index");
		}
		else
			mv.setViewName("login");
		Format f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String oldtel="1532132132-929722";
		int i=0;
		Date oldate=new Date();
//		a.add(new testPO());
		for (testPO testPO : a) {
			//			//多一条数据
			if (testPO.getCallerno().equals(oldtel)) {
				i+=testPO.getTimes();
				if (testPO.getDevicetype()==2) {
					i=0;	
				}
//				if (testPO.getDevicetype()==1) {
//					i+=testPO.getTimes();
//				}
//					i=0;
//					if (testPO.getCallidnum()!=-1) {
//						flag=true;
//					}
//				}
//				if (testPO.getDevicetype()==3) {
//					if (testPO.getCallidnum()==-1) {
//						//如果找到id相等并且有type有2得的就跳过；否则加1
//						if (flag) {
//							i=0;
//							flag=false;
//						}
//						else {
//							i++;
//						}
//					}
//					else
//						i++;
//				}
			}
			else {
				smart.modify(oldtel, i,f.format(oldate));
//				flag=false;
//				SmartQueueTimesPO po =new SmartQueueTimesPO();
//				po.setCallerno(oldtel);
//				po.setQueueTimes(i);
//				smart.insert(po);
//				
				oldtel=testPO.getCallerno();
				i=testPO.getTimes();
				oldate=testPO.getWaitbegin();
			}
		}
  */
}
