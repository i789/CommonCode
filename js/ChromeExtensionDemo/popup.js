function clickHandler(element) {
  loadImg();
}
function loadImg(){
  var imgUrl = document.getElementById("imgUrl").value;
  document.getElementById("myImage").src = imgUrl;
}
document.addEventListener('DOMContentLoaded', function () {
          document.querySelector('button').addEventListener('click', clickHandler);
        });
// 不执行内联事件。这条规则将同时禁止内嵌<script>块和内联事件（例如： <button onclick="...">）。
