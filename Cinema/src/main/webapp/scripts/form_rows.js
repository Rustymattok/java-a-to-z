let json= getJson('/json');
let jsonData= getJson('/jsonacc');
let list =[];
/**
 * Method responsible for forming <br> teg.
 * @returns {HTMLTableRowElement}
 */
function createRowBr(){
    var br = document.createElement('tr');
    console.log(br);
    return br;
}
/**
 * Method responsible for forming html structure of buttons.
 * @param num - value of buttons.
 * @param k - numbers of buttons
 * @returns {HTMLLabelElement}
 */
function generateButtons(num,k) {
    var lb = document.createElement('label');
    var btm = document.createElement('button');
    lb.className = "btn-group btn-group-lg";
    btm.type = "button";
    btm.id = k;
    if(json[k].status === "block"){
        btm.className = "btn";
        btm.disabled = true;
    }else{
        btm.className="btn btn-primary";
    }
    btm.innerText = num;
    lb.appendChild(btm);
    return lb;
}
function getJson(url) {
    return JSON.parse($.ajax({
        type: 'GET',
        url: url,
        dataType: 'json',
        global: false,
        async: false,
        success: function (data) {
            return data;
        }
    }).responseText);
}

function updateJson(){
    $.post("/json", {
        list:list,
    });
    console.log(list);
    return false;
}
/**
 * Send to ServletAccount data.
 * @param username - name of customer.
 * @param phone - phone of customer.
 * @param list - data of halls wich were blocked by customer.
 * @returns {boolean}
 */
function sendAccount(username,phone) {
    $.post("/account", {
        name:username,
        phone:phone,
        list:list,
    });
    return false;
}
/**
 * Send to JSONAccount data of choosed places.
 * @returns {boolean}
 */
function jsonAcc(){
    $.post("/jsonacc", {
        list:list,
    });
    console.log(list);
    return false;
}
/**
 * Data for order,html. <h5>Insert text by data.</h5>.
 * @returns {HTMLHeadingElement}
 */
function generateHatrib() {
    var h3form = document.createElement('h5');
    var text = " ";
    for(var k in jsonData){
        text = text + "row=" +jsonData[k].row + " place=" +jsonData[k].place + " ";
    }
    h3form.innerText = "вы выбрали след места: " + text;
    return h3form;
}
/**
 * Take data from order form( name and phone) and send it to servlet Json.
 * @returns {boolean}
 */
function fromOrderForm() {
    var name = document.getElementById("username").value;
    var phone = document.getElementById("phone").value;
    for(let k in jsonData){
        list.push(jsonData[k].id);
    }
    console.log(list);
    sendAccount(name,phone,list);
    return false;
}
/**
 * Method responsible for forming order.html.
 * @returns {boolean}
 */
function orderapp() {
    console.log(jsonData);
    let tabH = document.getElementById("stocID");
    tabH.getElementsByTagName('tbody')[0].appendChild(generateHatrib());
    return false;
}
/**
 * Method responsible for forming index.html.
 * @returns {boolean}
 */
function app() {
    var k = 1;
    let tabStoc = document.getElementById("stoc");
    console.log(tabStoc);
    let stocButtons = document.getElementById("stocButtons");
    console.log(stocButtons);
    for (let i = 0; i < 10; i++) {
        for (let j = 0; j < 19 ; j++) {
            tabStoc.getElementsByTagName('tbody')[0].appendChild(generateButtons(j+1,k));
            if (json[k].status === "free"){
                tabStoc.onclick = function (event) {
                    let bt = event.target.closest('button'); // (1)
                    bt.className = "btn btn-info";
                    list.push(bt.id);
                }
            }
            k++;
        }
        tabStoc.getElementsByTagName('tbody')[0].appendChild(createRowBr());
    }
    return false;
}