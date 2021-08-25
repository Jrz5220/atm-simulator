console.log("Welcome to the ATM");

// Restricts input for the given textbox to the given inputFilter function
function setInputFilter(textbox, inputFilter) {
 	["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function(event) {
	// initiated once for each function call below. event undefined, not null.
    textbox.addEventListener(event, function() {
      if (inputFilter(this.value)) {
        this.oldValue = this.value;
        this.oldSelectionStart = this.selectionStart;
        this.oldSelectionEnd = this.selectionEnd;
      } else if (this.hasOwnProperty("oldValue")) {
        this.value = this.oldValue;
        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
      } else {
        this.value = "";
      }
    });
  });
}

let numOnlyInputs = document.getElementsByClassName("numbers-only");

for(var i = 0; i < numOnlyInputs.length; i++ ) {
	setInputFilter(numOnlyInputs[i], function(value) {
		return /^\d*\d*$/.test(value); // Allow digits, using a RegExp
	});
}

function displayPin() {
	document.getElementById("eyeIcon").className = "fas fa-eye";
	let pinInput = document.getElementById("newPin");
	pinInput.type = "text";
}

function hidePin() {
	document.getElementById("eyeIcon").className = "fas fa-eye-slash";
	let pinInput = document.getElementById("newPin");
	pinInput.type = "password";
}
