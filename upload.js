const fs = require("fs");

function saveFile(filename, content) {

    // Path traversal vulnerability
    fs.writeFileSync("/uploads/" + filename, content);

}

saveFile("../../etc/passwd", "hacked");