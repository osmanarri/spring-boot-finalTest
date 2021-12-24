function deleteRow() {

  var txt;

  var r = confirm("ARE YOU SURE!");
  if (r == true) {
    txt = "ROW DELETED";
  } else {
    txt = " ";
  }
  document.getElementById("demo").innerHTML = txt;
}

function updateRow() {

  var txt = "ROW UPDATED";  
  document.getElementById("demo").innerHTML = txt;
}


