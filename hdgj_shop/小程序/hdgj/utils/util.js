const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

const moment = require('moment.min.js');
function timestampToString(timestamp,str) {
  moment.locale('en', {
    longDateFormat: {
      l: "YYYY-MM-DD",
      L: "YYYY-MM-DD HH:mm:ss"
    }
  });
  return moment(timestamp).format(str);
}


module.exports = {
  formatTime: formatTime,
  timestampToString: timestampToString
}
