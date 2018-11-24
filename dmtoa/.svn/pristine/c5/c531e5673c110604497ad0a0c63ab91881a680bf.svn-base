$.extend($.messager.defaults,{ok:"确定",cancel:"取消"});

/**
 * DMT框架自定义与后台异步请求方式，自定义是否需要校验session
 * validate为true的情况下请求先到后台后会先校验登陆用户的session是否过期，过期的情况下返回登陆界面
 * 没有过期的情况下继续执行URL请求
 * validate为false的情况下直接执行url请求
 * @author duanwu
 * @param url 调用请求URL
 * @param params 请求参数 json格式
 * @param validate 是否校验session 默认为false
 * @param success 回掉方法
 * 
 * 举例：
 *
 	DMTRequest({
		url:'loginAction/test.do',
		params:{aa:'aa',bb:'bb'},
		validate:false,
		success:function(data){
			console.log(data);
		}
	});
 */
function DMTRequest(param) {
	//打开数据加载框
	loadOpen();
	if(!param.validate){
		//不需要校验的情况下直接请求数据
		//直接执行用户请求
		$.post(param.url, param.params, function(data) {
			//关闭加载框
			loadClose();
			//将返回的json字符串转换成json对象
			var res;
			try{
				res = JSON.parse(data);
			}catch(e){
				res = data;
			}
			if(res.status=="1"){
				$.messager.alert("系统错误", res.errorMsg, "error");
			}else{
				//调用自定义的回调方法处理业务
				param.success(res);
			}
		});
	}else{
		//需要校验的情况下先校验session信息，在请求数据
		var url = param.url;
		var reurl = url.substring(0,url.lastIndexOf("/"));
		var validateUrl = reurl.substring(0,reurl.lastIndexOf("/")+1)+"systemAction/validateSession.do";
		var rankUrl = reurl.substring(0,reurl.lastIndexOf("/")+1)+"systemAction/rankIndex.do";
		$.post(
			validateUrl,
			function(data){
				var res;
				try{
					res = JSON.parse(data);
				}catch(e){
					res = data;
				}
				if(res.status=="1"){
					//关闭加载框
					loadClose();
					//session过期，跳转到登陆界面
					$.messager.alert("系统提示", res.errorMsg, "error",function(){rankIndex(rankUrl);});
					setTimeout(function(){rankIndex(rankUrl);},2000);
				}else{
					//继续用户请求
					$.post(param.url, param.params, function(data1) {
						//关闭加载框
						loadClose();
						//将返回的json字符串转换成json对象
						var res1;
						try{
							res1 = JSON.parse(data1);
						}catch(e){
							res1 = data1;
						}
						if(res1.status=="1"){
							$.messager.alert("系统错误", res1.errorMsg, "error");
						}else{
							//调用自定义的回调方法处理业务
							param.success(res1);
						}
					});
				}
			}
		);
	}
	
}

/**
 * DMT框架自定义数据表格UI控件
 * @author duanwu
 * @param id table标签id
 * @param url 请求的数据URL
 * @param params 数据查询的条件，json格式
 * @param title 数据表格的标题
 * @param page 是否显示分页栏，默认true
 * @param checkbox 是否显示复选框
 * @param columns 表格头部数据
 * @param toolbar 表格操作按钮
 * @param validate 是否需要session校验，默认false
 * @param success 回调方法
 * 示例：
 * 		//查询角色数据
		DMTDatatable({
			id:"#datagrid", //需要被填充的table
			title:"角色列表",  //数据名称
			url:"../../roleAction/roleList.do",  //数据url
			params:{
				name:$("input[name=condition_name]").val(),
				status:$("select[name=condition_status]").val()
			},
			checkbox:false,  //每条数据前是否带checkbox复选框
			//表头数据，field：字段名称   title:显示名称  width:单元格长度  fixWidth(比例):返回宽度的对应比例长度，0.3代表30%
			columns:[[
			    {field:'name',title:'角色名称',width:fixWidth(0.1)},
			    {field:'number',title:'用户数量',width:fixWidth(0.1),align:'center'},
			    {field:'description',title:'角色描述',width:fixWidth(0.3)},
			    {field:'createtimeCopy',title:'创建时间',width:fixWidth(0.2),align:'center'},
			    {field:'statusCopy',title:'角色状态',width:fixWidth(0.1),align:'center'},
			    {field:'_opt',title:'操作',width:fixWidth(0.2),align:'center',
			    	formatter:function(value,rec){
	                var html = '<a href="javascript:editRole(\''+rec.id+'\');">编辑</a> '; 
	                if(rec.number == '0'){
	                	html += '| <a href="javascript:deleteRole(\''+rec.id+'\');">删除</a> ';
	                }
	                if(rec.status == '0'){
	                	html += '|<a href="javascript:statusRole(\''+rec.id+'\',\'1\');">禁用</a>';
	                }else{
	                	html += '|<a href="javascript:statusRole(\''+rec.id+'\',\'0\');">启用</a>'
	                }
	                return html; 
	               }
			    }
			]],
			//操作按钮
			toolbar:[{ 
		        text: '添加', 
		        iconCls: 'icon-add', 
		        handler: function() { 
		            addRole(); 
		        } 
		    }]
		});
 */
function DMTDatatable(param){
	var page = true;
	if(param.page == false){
		page = false;
	}
	var pageSize = param.pageSize;
	if(pageSize==null||pageSize==""||typeof(pageSize)=="undefined"||pageSize=="undefined"){
		pageSize = 10;
	}
	var footer = false;
	if(param.showFooter == true){
		footer = true;
	}
	if(!param.validate){
		$(param.id).datagrid({
			title:param.title, 
		    url:param.url,
//		    height:'2000px', //设置一个比较大的值即可
		    nowrap: true, //禁止单元格中的文字自动换行
		    queryParams:param.params,
		    singleSelect:false,//是否单选 
		    pagination:page,//分页控件
		    rownumbers:true,//行号 
		    pageSize:pageSize,//分页大小
		    striped: true, //条纹样式
		    showFooter:footer, //显示行脚
		    frozenColumns:[[ 
		       {field:'checkbox',checkbox:param.checkbox} 
		    ]], 
		    columns: param.columns,
		    toolbar: param.toolbar,
		    onLoadSuccess:param.success
		});
	}else{
		//需要校验的情况下先校验session信息，在请求数据
		var url = param.url;
		var reurl = url.substring(0,url.lastIndexOf("/"));
		var validateUrl = reurl.substring(0,reurl.lastIndexOf("/")+1)+"systemAction/validateSession.do";
		var rankUrl = reurl.substring(0,reurl.lastIndexOf("/")+1)+"systemAction/rankIndex.do";
		$.post(
			validateUrl,
			function(data){
				var res = JSON.parse(data);
				if(res.status=="1"){
					//关闭加载框
					//session过期，跳转到登陆界面
					$.messager.alert("系统提示", res.errorMsg, "error",function(){rankIndex(rankUrl);});
					setTimeout(function(){rankIndex(rankUrl);},2000);
				}else{
					$(param.id).datagrid({
						title:param.title, 
					    url:param.url,
					   // height:'2000px', //设置一个比较大的值即可
					    nowrap: true, //禁止单元格中的文字自动换行
					    queryParams:param.params,
					    singleSelect:false,//是否单选 
					    pagination:true,//分页控件
					    rownumbers:true,//行号 
					    striped: true, //条纹样式
					    pageSize:pageSize,//分页大小
					    showFooter:footer, //显示行脚
					    frozenColumns:[[ 
					       {field:'checkbox',checkbox:param.checkbox} 
					    ]], 
					    columns: param.columns,
					    toolbar: param.toolbar,
					    onLoadSuccess:param.success
					});
				}
			}
		);
	}
}

/**
 * 为指定form表单中所有的输入框绑定对应的校验规则
 * @param id
 * 规则如下：
 * NOTNULL:必须输入
 * MONEY:金额字段
 * PHONE:手机号
 * TEL:电话号码
 * CHINESE:中文
 * INTEGER1:不为0的正整数
 * INTEGER2:非负整数
 * NUMBER:数字
 * LETTER:英文字母
 * LETTER_NUMBER:字母或者数字
 * LETTER_NUMBER_LINE:数字、字母、下划线
 * EMAIL:Email
 * INTNET:网址
 * CERTNO:身份证号码
 * PERCENT:百分比
 */
function DMTForm(id){
	//查找所有的input绑定指定的校验规则
	$("#"+id).find("input[type=text],input[type=datetime],textarea").each(function(){
		var bind = $(this).attr("bind");
		if(bind=="true") return;
		$(this).attr("bind","true");
		$(this).parent().append("<lable mark='msg' style='color:red;margin-left:5px;'></lable>");
		var rules = $(this).attr("validate");
		//当validate属性为空时，结束，不再进行下面的blur事件，防止自己写的blur事件不起作用
		if(rules==null||rules==""||typeof(rules)=="undefined") return;
		$(this).blur(function(){
			var value = $(this).val().trim();
			var res = validate($(this),rules,value);
			if(!res){
				$(this).css("border-color","red");
			}else{
				$(this).css("border-color","#9FCAF4");
			}
		});
	});
	//查找所有的select绑定指定的校验规则
	/*$("#"+id).find("select").each(function(){
		$(this).parent().append("<lable style='color:red;margin-left:5px;'></lable>");
		var rules = $(this).attr("validate");
		
		$(this).blur(function(){
			var value = $(this).val().trim();
			var res = validate(rules,value);
			if(!res){
				$(this).css("border-color","red");
			}else{
				$(this).css("border-color","#9FCAF4");
			}
		});
	});*/
}

/**
 * 根据指定的值和校验规则校验指定的值
 * @param rules 校验规则
 * @param value 校验值
 */
function validate(obj,rules,value){
	$(obj).parent().find("lable").html("");
	//校验是否为空
	if(rules.indexOf("NOTNULL")!=-1&&value==""){
		$(obj).parent().find("lable").html("不能为空");
		return false;
	}
	//校验是否为金额
	if(rules.indexOf("MONEY")!=-1&&formatMoney(value).match("^(([1-9]\\d{0,9})|0)(\\.\\d{1,2})?$")==null){
		$(obj).parent().find("lable").html("金额格式不正确");
		return false;
	}
	//校验是否为手机号
	if(rules.indexOf("PHONE")!=-1&&value.match("^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|7[0-9])\\d{8}$")==null){
		$(obj).parent().find("lable").html("手机号格式不正确");
		return false;
	}
	//校验是否为电话号码
	if(rules.indexOf("TEL")!=-1&&value.match("0\\d{2,3}-\\d{5,9}|0\\d{2,3}-\\d{5,9}")==null){
		$(obj).parent().find("lable").html("电话号码格式不正确");
		return false;
	}
	//校验是否为中文
	if(rules.indexOf("CHINESE")!=-1&&value.match("^[\u4e00-\u9fa5]{0,}$")==null){
		$(obj).parent().find("lable").html("请输入中文");
		return false;
	}
	//校验是否为数字
	if(rules.indexOf("NUMBER")!=-1&&value.match("^[0-9]*$")==null){
		$(obj).parent().find("lable").html("请输入数字");
		return false;
	}
	//校验是否为正整数
	if(rules.indexOf("INTEGER1")!=-1&&value.match("^([1-9][0-9]*){1,3}$")==null){
		$(obj).parent().find("lable").html("请输入正整数");
		return false;
	}
	//校验是否为非负整数
	if(rules.indexOf("INTEGER2")!=-1&&value.match("^[1-9]\\d*|0$")==null){
		$(obj).parent().find("lable").html("请输入非负整数");
		return false;
	}
	//校验是否为英文字母
	if(rules.indexOf("LETTER")!=-1&&value.match("^[A-Za-z]+$")==null){
		$(obj).parent().find("lable").html("请输入英文字母");
		return false;
	}
	//校验是否为英文或者数字
	if(rules.indexOf("LETTER_NUMBER")!=-1&&value.match("^[A-Za-z0-9]+$")==null){
		$(obj).parent().find("lable").html("请输入字母或者数字");
		return false;
	}
	//校验是否为字母、数字或者下划线
	if(rules.indexOf("LETTER_NUMBER_LINE")!=-1&&value.match("^\\w+$")==null){
		$(obj).parent().find("lable").html("请输入字母、数字或者下划线");
		return false;
	}
	//校验是否为Email
	if(rules.indexOf("EMAIL")!=-1&&value.match("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")==null){
		$(obj).parent().find("lable").html("Email格式不正确");
		return false;
	}
	//校验是否为网址
	if(rules.indexOf("INTERNET")!=-1&&value.match("^(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$")==null){
		$(obj).parent().find("lable").html("网址格式不正确");
		return false;
	}
	//校验是否为身份证号码
	if(rules.indexOf("CERTNO")!=-1&&value.match("^([0-9]){7,18}(x|X)?$")==null){
		$(obj).parent().find("lable").html("请输入正确的身份证号码");
		return false;
	}
	//校验是否为百分比
	if(rules.indexOf("PERCENT")!=-1&&value.match("^(100|([1-9]?[0-9]{1}))(\.[0-9]{1}[0-9]?)?$")==null){
		$(obj).parent().find("lable").html("请输入正确的百分比");
		return false;
	}
	return true;
}

/**
 * 为指定的form表单校验数据
 * @param id
 */
function DMTValidate(id){
	var temp = true;
	$("#"+id).find("input[type=text],input[type=datetime]").each(function(){
		var rules = $(this).attr("validate");
		if(!(typeof(rules) == "undefined")){
			var value = $(this).val();
			var res = validate($(this),rules,value);
			if(!res){
				temp =  false;
			}
		}
	});
	/*$("#"+id).find("select").each(function(){
		var rules = $(this).attr("validate");
		if(!(typeof(rules) == "undefined")){
			var value = $(this).val();
			var res = validate($(this),rules,value);
			if(!res){
				temp =  false;
			}
		}
		
	});*/
	return temp;
}

/**
 * 加载的时候将加载框初始化
 */
$(function(){
	$("<div class=\"datagrid-mask\" style=\"z-index:9007;\"></div>").css({display:"none",width:"100%",height:$(window).height()}).appendTo("body"); 
	$("<div class=\"datagrid-mask-msg\" style=\"z-index:9008;\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"none",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
});

/**
 * 打开加载框
 */
function loadOpen(){
	$(".datagrid-mask").show();
	$(".datagrid-mask-msg").show();
}

/**
 * 关闭加载框
 */
function loadClose(){
	$(".datagrid-mask").hide();
	$(".datagrid-mask-msg").hide();
}

/**
 * 计算表格的宽度
 * @param percent
 * @returns {Number}
 */
function fixWidth(percent){
	var px = (document.body.clientWidth * 0.9 - 80) * percent ;
	return parseInt(px);
}

/**
 * 跳转到登陆页
 * @param rankUrl
 */
function rankIndex(rankUrl){
	DMTRequest({
		url:rankUrl,
		validate:false,
		success:function(data){
			var index = data.result;
			top.location.href = index+"/";
		}
	});
}

/**
 * 处理特殊字符，如：
 * &lt;&gt;&nbsp;
 * @param str
 */
function decode(str){
	str = str.replace(/\&lt;/g,"<");
	str = str.replace(/\&gt;/g,">");
	str = str.replace(/\&nbsp;/g," ");
	str = str.replace(/\&quot;/g,"'");
	return str;
}

/**
 * 加载下拉框数据
 * @param id
 * @param code
 */
function DMTSelectData(id,code,value){
	DMTRequest({
		url:'../../systemAction/findParamByCode.do',
		params:{
			code:code,
		},
		validate:true,
		success:function(data){
			var res = data.result;
			/*if(code=="INNER_AGENT"){
				console.log(res);
			}*/
			for(var i=0;i<res.length;i++){
				$("#"+id).append("<option value='"+res[i].key+"'>"+res[i].value+"</option>");
			}
			$("#"+id).val(value);
		}
	});
}

/**
 * 获取参数
 * 使用方法
 * location.href = 'xxxxx.html?aaa=111&bbb=222&ccc=333';
 * 
 * $(function(){
 * 		var param = DMTParameter();
 * 		console.log(param.aaa);
 * 		console.log(param.bbb);
 * 		console.log(param.ccc);
 * });
 * 
 * 打印如下：
 * 111
 * 222
 * 333
 */
function DMTParameter(){
	var url = document.URL;    
	var res = {};
	var str =url.split('?');
	if(str.length>1){
		var params = str[1];
		var paramArr = params.split("&");
		for(var i=0;i<paramArr.length;i++){
			var keyValue = paramArr[i].split("=");
			var key = keyValue[0];
			var value = keyValue[1];
			res[key] = value;
		}
	}
	return res;
}

/**
 * 转换成金额格式
 * @param val
 * @returns
 */
function formatMoney(val) 
{ 
	var str = val;
	var intSum = str.substring(0,str.indexOf(".")).replace( RegExp('\,',["g"]),'' );//取到整数部分
	var dot = str.substring(str.length,str.indexOf("."));//取到小数部分
	var ret = intSum + dot;
	return ret;
} 
/**
 * 将金额转换成带有两位数和逗号的格式
 * @param val
 * @returns
 */
var str1;  //全局变量
function formatNum(str){
	var newStr = "";
	var count = 0;
	str1 = "";
	if(typeof(str)=="undefined"){
		return "";
	}else if(str==0){
		return "0.00";
	}else{
		str = str + "";
		str = str.replace(/\,/g, ""); 
		if(str.indexOf(".")==-1){
		   for(var i=str.length-1;i>=0;i--){
		 if(count % 3 == 0 && count != 0){
		   newStr = str.charAt(i) + "," + newStr;
		 }else{
		   newStr = str.charAt(i) + newStr;
		 }
		 count++;
		   }
		   str1 = newStr + ".00"; //自动补小数点后两位
		}
		else
		{
		   for(var i = str.indexOf(".")-1;i>=0;i--){
		 if(count % 3 == 0 && count != 0){
		   newStr = str.charAt(i) + "," + newStr;
		 }else{
		   newStr = str.charAt(i) + newStr; //逐个字符相接起来
		 }
		 count++;
		   }
		   str1 = newStr + (str + "00").substr((str + "00").indexOf("."),3);
		 }
		return str1;
	}
};

function DMTInitMsg(){
	$("lable[mark=msg]").each(function(){
		$(this).html('');
		$(this).parent("td").find("input,select").css("border-color","#9FCAF4");
	});
}
