const page = require('webpage').create();
const system = require('system');

page.open(system.args[1], function () {
    page.evaluate(function () {
        document.body.bgColor = 'white';
    });
    page.render(system.args[2]);
    phantom.exit();
});