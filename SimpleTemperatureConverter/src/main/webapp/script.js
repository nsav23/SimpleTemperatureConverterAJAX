var req;

function convertToCelsius(event) {

    if (event.key === "Enter") {

        var inputUnit = document.getElementById("unitF");
        var value = inputUnit.value;

        var url = "/SimpleTemperatureConverter/convert?fahrenheit=" + encodeURIComponent(value);                        //encodeURIComponent(value) because user might input something other than number and cause error

        if (window.XMLHttpRequest) {

            req = new XMLHttpRequest();

        }else if (window.ActiveXObject) {

            req = new ActiveXObject("Microsoft.XMLHTTP");

        }

        req.open("Get", url, true);
        req.onreadystatechange = callback;                                                                              // triggers a function every time request changes state, when something changes runs callback()
        req.send(null);                                                                                                 // sends the request to the server

    }

}

function callback() {

    if (req.readyState === 4) {                                                                                         //4	Request finished and response is ready

        if (req.status === 200) {                                                                                       //2	Request received

            // This retrieves the XML document returned by the servlet
            var xml = req.responseXML;
            // This attempts to find the <result> element in the XML
            var result = xml.getElementsByTagName("result")[0].textContent;
            // This finds the input field with id="celsius"
            var celsius = document.getElementById("celsius");
            // This sets the input field's value to the result extracted from XML
            celsius.value = result;

        }

    }

    clear();

}

function clear() {

    var inputUnit = document.getElementById("unitF");
    inputUnit.value = "";

}