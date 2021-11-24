export default function authHeaderWithContent() {
    const user = JSON.parse(localStorage.getItem('user'));
  
    if (user && user.accessToken) {
      return { 
        Authorization: 'Bearer ' + user.accessToken,
        'Content-type': 'application/json; charset=UTF-8'
     };
    } else {
      return {'Content-type': 'application/json; charset=UTF-8'};
    }
  }
  