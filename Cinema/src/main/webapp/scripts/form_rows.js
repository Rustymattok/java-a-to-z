function createRowBr(){
    var br = document.createElement('tr');
    console.log(br);
    return br;
}
function generateButtons(num) {
    var lb = document.createElement('label');
    var btm = document.createElement('button');
    lb.className = "btn-group btn-group-lg";
    btm.type = "button";
    btm.className="btn btn-primary";
    btm.innerText = num;
    lb.appendChild(btm);
    return lb;
}
//todo вместо обычных кнопок сформировать кноки radio.
function app() {
   let  tabStoc = document.getElementById("stoc");
    for (let i = 0; i < 10; i++) {
        for (let j = 0; j < 19 ; j++) {
            tabStoc.getElementsByTagName('tbody')[0].appendChild(generateButtons(j+1));
            tabStoc.onclick = function (event) {
                let bt = event.target.closest('button'); // (1)
                bt.className ="btn btn-info";
            }
        }
        tabStoc.getElementsByTagName('tbody')[0].appendChild(createRowBr());
    }
    return false;
}
