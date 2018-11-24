$(function(){
	InitLeftMenu();
	tabClose();
	tabCloseEven();
	clockon();
});

var _menus;

//初始化左侧
function InitLeftMenu() {
	
//	var _menus = {"menus":[
//							{"menuid":"1","icon":"icon-sys","menuname":"系统管理",
//								"menus":[{"menuname":"菜单管理","url":"http://www.nongfuit.com"},
//										{"menuname":"添加用户","url":"demo.html"},
//										{"menuname":"用户管理","url":"demo2.html"},
//										{"menuname":"角色管理","url":"demo2.html"},
//										{"menuname":"权限设置","url":"demo.html"},
//										{"menuname":"系统日志","url":"demo.html"}
//									]
//							},{"menuid":"8","icon":"icon-sys","menuname":"员工管理",
//								"menus":[{"menuname":"员工列表","url":"demo.html"},
//										{"menuname":"视频监控","url":"demo1.html"}
//									]
//							},{"menuid":"56","icon":"icon-sys","menuname":"部门管理",
//								"menus":[{"menuname":"添加部门","url":"demo1.html"},
//										{"menuname":"部门列表","url":"demo2.html"}
//									]
//							},{"menuid":"28","icon":"icon-sys","menuname":"财务管理",
//								"menus":[{"menuname":"收支分类","url":"demo.html"},
//										{"menuname":"报表统计","url":"demo1.html"},
//										{"menuname":"添加支出","url":"demo.html"}
//									]
//							},{"menuid":"39","icon":"icon-sys","menuname":"商城管理",
//								"menus":[{"menuname":"商品分","url":"/shop/productcatagory.aspx"},
//										{"menuname":"商品列表","url":"/shop/product.aspx"},
//										{"menuname":"商品订单","url":"/shop/orders.aspx"}
//									]
//							}
//					]};

	//加载左侧菜单数据
	DMTRequest({
    	url:'systemAction/menu.do',
    	validate:true,
    	success:function(data){
    		_menus = data.result;
    		initMenu();
    	}
	});
}

//初始化菜单
function initMenu(){
	var menus = _menus.menus;
	
//	<ul class="ulleft" id="base_set" style="display:none;">
//    <div class="leftone">基本设置</div>
//    <li><a href="javascript:void(0);" id="set_site_op" class="this" onclick="openURL('url','$!webPath/admin/set_site.htm','main_workspace','set_site_op')">站点设置</a></li>
//    <li><a href="javascript:void(0);" id="set_image_op" onclick="openURL('url','$!webPath/admin/set_image.htm','main_workspace','set_image_op')">上传设置</a></li>
//    <li><a href="javascript:void(0);" id="set_seo_op" onclick="openURL('url','$!webPath/admin/set_seo.htm','main_workspace','set_seo_op')">SEO设置</a></li>
//  </ul>
	
	for(var i=0;i<menus.length;i++){
		$("#first_menu").append('<li><a href="javascript:void(0);" class="active" id="'+menus[i].menuid+'_menu" onclick="openURL(\'show\',\''+menus[i].menuid+'\')">'+menus[i].menuname+'</a></li>');
		var submenustr = '<ul class="ulleft" id="'+menus[i].menuid+'" style="display:none;"><div class="leftone">'+menus[i].menuname+'</div>';
		var submenus = menus[i].menus;
		for(var j=0;j<submenus.length;j++){
			submenustr += '<li><a href="javascript:void(0);" id="'+submenus[j].menuid+'_op" class="this" onclick="openURL(\'url\',\''+submenus[j].url+'\',\'main_workspace\',\''+submenus[j].menuid+'_op\')">'+submenus[j].menuname+'</a></li>';
		}
		submenustr += '</ul>';
		$("#sub_menu").append(submenustr);
	}
}

function addTab(subtitle,url){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			width:$('#mainPanle').width()-10,
			height:$('#mainPanle').height()-26
		});
	}else{
		$('#tabs').tabs('select',subtitle);
	}
	tabClose();
}

function createFrame(url)
{
	var s = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children("span").text();
		$('#tabs').tabs('close',subtitle);
	});

	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY,
		});
		
		var subtitle =$(this).children("span").text();
		$('#mm').data("currtab",subtitle);
		
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	});
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});	
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t!=currtab_title)
				$('#tabs').tabs('close',t);
		});	
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	});
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

function clockon() {
    var now = new Date();
    var year = now.getFullYear(); //getFullYear getYear
    var month = now.getMonth();
    var date = now.getDate();
    var day = now.getDay();
    var hour = now.getHours();
    var minu = now.getMinutes();
    var sec = now.getSeconds();
    var week;
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    if (hour < 10) hour = "0" + hour;
    if (minu < 10) minu = "0" + minu;
    if (sec < 10) sec = "0" + sec;
    var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
    week = arr_week[day];
    var time = "";
    time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu + ":" + sec + " " + week;

    $("#bgclock").html(time);

    setTimeout("clockon()", 1000);
}
