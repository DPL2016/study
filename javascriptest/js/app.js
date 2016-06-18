(function(){

	//添加任务文本框
	var input = document.getElementById("input-newtodo");
	//已完成任务的数字
	var finishNum = document.getElementById("finishNum");
	//已完成任务的链接
	var doneTaskNum = document.getElementById("doneTaskNum");
	//未完成的任务列表
	var newList = document.getElementById("newList");
	//已完成的任务列表
	var finishList = document.getElementById("finishList");


	//基础数据
	var data = [
		{todo:"购买5号电池",finish:false},
		{todo:"给公司发邮件说明客户情况",finish:false},
		{todo:"学习 Node.js",finish:false},
		{todo:"Alex的生日礼物",finish:false}
	];

	//显示任务列表函数
	function runder(){
		for(var index in data) {
			var obj = data[index];
			runderTodo(obj.todo,obj.finish);
		}
	}

	//显示一个任务
	function runderTodo(todo,isFinish) {
		//<li>
		//	<div class="task-warpper">
		//		<a href="javascript:;" class="ck-warpper"><span class="checkbox"></span></a>
		//		<span class="text">明天给Alex 打电话</span>
		//	</div>
		//</li>
		
		//创建 li 元素
		var li = document.createElement("li");
		//创建 div 元素
		var div = document.createElement("div");
		//创建 a 元素
		var a = document.createElement("a");
		//创建 a 中的 span 元素
		var spanCheck = document.createElement("span");
		//创建显示文本的 span 元素
		var spanText = document.createElement("span");
		//创建文本节点
		var text = document.createTextNode(todo);

		//添加各个元素的属性
		div.setAttribute("class","task-warpper");
		a.setAttribute("href","javascript:;");
		a.setAttribute("class","ck-warpper");
		spanCheck.setAttribute("class","checkbox");
		spanText.setAttribute("class","text");
		if(isFinish) {
			//如果是已完成的任务，则在 li 标签上添加已完成的 class 属性
			li.setAttribute("class","done");
		}

		//设置各个元素之间的关系
		a.appendChild(spanCheck);
		spanText.appendChild(text);
		div.appendChild(a);
		div.appendChild(spanText);
		li.appendChild(div);

		//将 li 添加到 ul 中
		if(!isFinish) {
			newList.appendChild(li);
		} else {
			finishList.appendChild(li);
		}

	}

	//统计已完成的任务数量
	function getFinishTodo(){
		var total = 0;
		for(var index in data) {
			var obj = data[index];
			if(obj.finish) {
				total++;
			}
		}
		return total;
	}
	//初始化函数
	var init = function(){
		//设置已完成任务的数量
		finishNum.innerText = getFinishTodo();
		//将数据进行显示
		runder();
		//判断是否有已完成的任务，如果没有则隐藏【已完成 x 条任务】超链接
		if(getFinishTodo() == 0) {
			doneTaskNum.style.display = "none";
		}
	};
	init();



	//键盘输入事件
	input.onkeyup = function(event){
		//当按下的是回车键时
		if(event.keyCode == 13) {
			//获取文本框中的值
			var text = input.value;
			//将文本框内容清空
			input.value = "";

			//添加到基础数据中
			var todo = {todo:text,finish:false};
			data.push(todo);

			//将最新的任务显示出来
			runderTodo(text,false);
		}
	};

	//[已完成 x 条任务]超链接点击事件
	doneTaskNum.onclick = function(){
		if(finishList.getAttribute("class").indexOf("hide") != -1) {
			finishList.setAttribute("class","list");
		} else {
			finishList.setAttribute("class","list hide");
		}
	};

	//复选框单机事件(事件委托机制)
	document.onclick = function(event) {
		var target = event.target;
		if(target.getAttribute("class") == "checkbox") {
			ckClick(target);		
		}

	};
	function ckClick(target){
		var li = target.parentNode.parentNode.parentNode;
		if(!li.getAttribute("class")){
			//从未完成列表中删除该项
			li.parentNode.removeChild(li);

			//设置完成项的 class 属性，并追加到已完成列表中
			li.setAttribute("class","done");
			finishList.appendChild(li);

			//更改已完成任务的数字，并显示
			var doneNum = parseInt(finishNum.innerText);
			finishNum.innerText = ++doneNum;
			doneTaskNum.style.display = "inline";			
			
		} else {
			//从已完成列表中删除该项
			li.parentNode.removeChild(li);

			//设置完成项的 class 属性，并追加到已完成列表中
			li.setAttribute("class","");
			newList.appendChild(li);

			//更改已完成任务的数字，并显示
			var doneNum = parseInt(finishNum.innerText);
			finishNum.innerText = --doneNum;
			if(doneNum != 0) {
				doneTaskNum.style.display = "inline";	
			} else {
				doneTaskNum.style.display = "none";	
			}
		}
	}




})();