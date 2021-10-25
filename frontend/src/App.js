import logo from './logo.svg';
import './App.css';
import User from './User';

// styles
import "./assets/css/button.css";
import "./assets/css/card.css";



function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
      <div className="container" style={{width: 500, alignSelf: 'center' | 20}}>
        
          <User />
        
        <button className="btn-round mr-1 btn-lg btn btn-outline-primary">Totti</button>
        <img src={logo} className="App-logo" alt="logo" />
      </div>
    </div>
  );
}

export default App;
