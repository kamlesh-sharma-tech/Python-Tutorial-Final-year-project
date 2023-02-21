let btn = document.getElementById("copyBtn");
new ClipboardJS(btn);

function myFunction(){
    document.getElementById("copyBtn").innerHTML = "Code Copied";
//    alert("Code Copied");
}