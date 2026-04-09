const express = require("express");
const app = express();

// Hardcoded secret
const SECRET = "super-secret-key";

app.get("/exec", (req, res) => {

    const cmd = req.query.cmd;

    const exec = require("child_process").exec;

    // Command injection
    exec(cmd, (err, stdout) => {
        res.send(stdout);
    });

});

app.get("/eval", (req, res) => {

    const code = req.query.code;

    

});

app.listen(3000);