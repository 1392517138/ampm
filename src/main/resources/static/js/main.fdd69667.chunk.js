(this.webpackJsonpsubmit=this.webpackJsonpsubmit||[]).push([[0],{142:function(e,t,a){e.exports=a(279)},161:function(e,t,a){},208:function(e,t,a){e.exports=a.p+"static/media/bg.7c03641f.png"},279:function(e,t,a){"use strict";a.r(t);var n=a(0),i=a.n(n),l=a(7),o=a.n(l),c=(a(280),a(136)),r=(a(85),a(83)),s=(a(278),a(82)),u=(a(281),a(137)),d=(a(159),a(61)),m=a(138),f=a(112),p=a(113),h=a(50),g=a(140),b=a(139),v=(a(87),a(30)),y=(a(161),a(59)),E=a.n(y),S=a(283),k=(v.a.Option,function(e){Object(g.a)(n,e);var t=Object(b.a)(n);function n(e){var a;return Object(f.a)(this,n),(a=t.call(this,e)).handleChangeTime=function(e){a.setState({time:e})},a.handleUpload=function(){var e=a.state,t=e.fileList,n=(e.time,new FormData);a.setState({uploading:!0});var i=Object(h.a)(a);t.forEach((function(e){n.append("multipartFile",e)})),E.a.post("http://pmzhaoxin.p3wj.top:9002/client/uploadsFile",n).then((function(e){console.log(e),"10000"==e.data.code||"30000"==e.data.code?(alert(e.data.message),i.setState({fileList:[],uploading:!1}),document.querySelector(".link").href=e.data.data,document.querySelector(".link").innerHTML="\u70b9\u51fb\u6b64\u5904\u4e0b\u8f7d\u4f60\u7684\u6587\u4ef6"):(i.setState({uploading:!1}),alert(e.data.message))})).catch((function(e){console.log(e),i.setState({uploading:!1}),alert("\u63d0\u4ea4\u5931\u8d25\uff01"+e.data.code)}))},a.state={num:"",file:"",currentTime:"",fileList:[],times:"",uploading:!1,infoList:["\u4e00\u4e2a\u538b\u7f29\u6587\u4ef6\uff0c\u5927\u5c0f\u5c0f\u4e8e50m","\u538b\u7f29\u6587\u4ef6\u540d\uff1a\u4e2d\u6587\u540d-\u7b2cx\u6b21\uff0c\u5982\u76ae\u6587\u666f-\u7b2c\u4e8c\u6b21","\u4e0a\u4f20\u6210\u529f\u4f1a\u4ee5\u90ae\u7bb1\u8fd4\u56de\u6587\u4ef6\u5730\u5740\uff0c\u8bf7\u81ea\u5df1\u68c0\u67e5\u662f\u5426\u6210\u529f\u3002\u5931\u8d25\u8bf7\u4e0e\u7ba1\u7406\u5458\u53d6\u5f97\u8054\u7cfb\u3002"]},a}return Object(p.a)(n,[{key:"componentDidMount",value:function(){var e=this;E.a.post("http://39.98.124.97:9002/client/getTiems").then((function(t){e.setState({times:t.data.data})})).catch((function(e){console.log(e)}))}},{key:"render",value:function(){var e=this,t=this.state,n=t.uploading,l=t.fileList,o=t.times,f={onRemove:function(t){e.setState((function(e){var a=e.fileList.indexOf(t),n=e.fileList.slice();return n.splice(a,1),{fileList:n}}))},beforeUpload:function(t){return e.setState((function(e){return{fileList:[].concat(Object(m.a)(e.fileList),[t])}})),!1},fileList:l,progress:{strokeColor:{"0%":"#108ee9","100%":"#87d068"},strokeWidth:3,format:function(e){return"".concat(parseFloat(e.toFixed(2)),"%")}}};return i.a.createElement("div",{className:"form-body"},i.a.createElement("img",{className:"bg-img",width:380,height:160,src:a(208)}),i.a.createElement("div",{className:"submit_body"},i.a.createElement(d.a,{orientation:"center"},i.a.createElement("span",{className:"title"},"\u4ea7\u54c1\u5e73\u53f0\u4f5c\u4e1a\u7b2c",i.a.createElement("span",{className:"title-times"},o),"\u6b21\u63d0\u4ea4")),i.a.createElement(s.b,{header:i.a.createElement("div",null,"\u4e0a\u4f20\u683c\u5f0f\u8981\u6c42"),bordered:!0,dataSource:this.state.infoList,renderItem:function(e,t){return i.a.createElement(s.b.Item,null,i.a.createElement(u.a.Text,{type:"secondary"},"".concat(t+1,"\u3001 "))," ",e)}}),i.a.createElement(d.a,{orientation:"center"}),i.a.createElement(c.a,f,i.a.createElement(r.a,null,i.a.createElement(S.a,null)," \u9009\u62e9\u538b\u7f29\u6587\u4ef6")),i.a.createElement(r.a,{type:"primary",onClick:this.handleUpload,disabled:0===l.length,loading:n,style:{marginTop:16}},n?"\u4e0a\u4f20\u4e2d":"\u5f00\u59cb\u4e0a\u4f20"),i.a.createElement(d.a,{orientation:"center"}),i.a.createElement("a",{href:"###",className:"link"})))}},{key:"file",value:function(){console.log(document.querySelector(".file").value),this.setState({file:document.querySelector(".file").value})}},{key:"submitFile",value:function(){var e=new FormData,t=document.querySelector(".file").files[0],a=document.querySelector("select").value;e.append("multipartFile",t),e.append("times",a),E.a.post("http://39.98.124.97:9002/client/uploadsFile",e).then((function(e){console.log(e),"10000"==e.data.code||"30000"==e.data.code?(alert(e.data.message),document.querySelector(".link").href=e.data.data,document.querySelector(".link").innerHTML="\u70b9\u51fb\u6b64\u5904\u4e0b\u8f7d\u4f60\u7684\u6587\u4ef6"):alert(e.data.message)})).catch((function(e){console.log(e),alert("\u63d0\u4ea4\u5931\u8d25\uff01"+e.data.code)}))}}]),n}(n.Component));o.a.render(i.a.createElement(k,null),document.getElementById("root"))}},[[142,1,2]]]);
//# sourceMappingURL=main.fdd69667.chunk.js.map