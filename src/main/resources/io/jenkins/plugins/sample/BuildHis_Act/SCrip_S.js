// var i = document.getElementById('GET_BUILD_NUM').value;
var SLog = document.getElementById('${it.Log}').nodeValue;
document.write("START");
document.write("<table border='1'>");
document.write("<tr>결과 값</tr>");
document.write("<tr>");
document.write("<th>빌드 번호</th>");
document.write("<th>시간</th>");
document.write("<th>값</th>");
document.write("</tr>");
                for(var i = 10;i >= 1;i--)
                {
                    document.write("<tr><td>",i,"</td><td>2020.11.10 오후 7:11","</td><td>",SLog);
                    document.write("</td></tr>");
                }
document.write("</table>");