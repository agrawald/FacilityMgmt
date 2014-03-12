function onUpdateDeleteClick(btn) {
    document.getElementById("action").value = btn.value;
    document.forms[0].submit();
}