let json= getJson('/todo/json');
/**
 * Get Json data - converted from DataBase.
 * @param url - link for json.
 * @returns {any} - json file.
 */
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
/**
 *This functiom for form list of tasks from DataBase.
 */
function takeData() {
    console.log(json)
    var ul = document.getElementById("myUL");
    for (var i = 0; i < json.length ; i++) {
        console.log(json[i].task)
        var li = document.createElement("li");
        li.id = json[i].id
        var t = document.createTextNode(json[i].task);
        li.appendChild(t);
        ul.appendChild(li);
        if(json[i].status === true){
            li.className = 'checked'
        }
    }
}
/**
 * This function responsable for include active buttoms with functionality for response.
 */
function app() {
// Create a "close" button and append it to each list item
    var myNodelist = document.getElementsByTagName("LI");
    var i;
    for (i = 0; i < myNodelist.length; i++) {
        var span = document.createElement("SPAN");
        var txt = document.createTextNode("\u00D7");
        span.className = "close";
        span.appendChild(txt);
        myNodelist[i].appendChild(span);
    }
// Click on a close button to hide the current list item
    var close = document.getElementsByClassName("close");
    var i;
    for (i = 0; i < close.length; i++) {
        close[i].onclick = function () {
            var div = this.parentElement;
            sendRemove(div.id);
            div.style.display = "none";
        }
    }
// Add a "checked" symbol when clicking on a list item
    var list = document.querySelector('ul');
    list.addEventListener('click', function (ev) {
        if (ev.target.tagName === 'LI') {
            ev.target.classList.toggle('checked');
            sendUpdate(ev.target.valueOf().task,true,ev.target.valueOf().id)
        }
    }, false);
}
/**
 * Formed json to send back servlet to add new task.
 * @param task - task wich was added.
 * @returns {boolean} - status( open or close).
 */
function sendTask(task) {
    let meetup = {
        task: task,
    };
    var result = JSON.stringify(meetup);
    $.post('/todo/json', {
        result:result
    });
    return false;
}
/**
 * Formed json to send back servlet to remove task by ID.
 * @param id -  which should remove.
 * @returns {boolean}
 */
function sendRemove(id) {
    let meetup = {
        id: id
    };
    var result = JSON.stringify(meetup);
    $.post('/todo/json', {
        result:result
    });
    return false;
}
/**
 * Formed json to send back servlet to update task by ID with new infor current task.
 * @param task
 * @param status
 * @param id
 * @returns {boolean}
 */
function sendUpdate(task,status,id) {
    let meetup = {
        task: task,
        status: status,
        id:id
    };
    var result = JSON.stringify(meetup);
    $.post('/todo/json', {
        result:result
    });
    return false;
}
/**
 * Function responsable for create new ADD.
 */
// Create a new list item when clicking on the "Add" button
function newElement() {
  var li = document.createElement("li");
  var inputValue = document.getElementById("myInput").value;
  var t = document.createTextNode(inputValue);
  li.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
    } else {
    document.getElementById("myUL").appendChild(li);
}
             document.getElementById("myInput").value = "";
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  li.appendChild(span);
  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
  var text = li.innerText.replace("\u00D7","")
  text = text.replace(/\n+/g,'')
  sendTask(text);
}
