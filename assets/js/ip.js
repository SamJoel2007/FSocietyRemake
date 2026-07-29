

//Version 1.0.1



document.addEventListener("DOMContentLoaded", () => {
    // when document is fully loaded the ip is fetched and then shown
    fetch("https://api.ipify.org?format=json")
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            //console.log("Fetched data:", data.ip);
            document.getElementById("userPublicIP").textContent = data.ip;
        })
        .catch(error => {
            console.error("Fetch error:", error);
        });
});
