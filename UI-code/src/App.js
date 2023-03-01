
import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css"
import './App.css';
import Dashboard from './components/Dashboard';
import Home from './components/Home';
import Login from './components/Login';
import { BrowserRouter, Switch, Route, NavLink } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <div className="content">
            <Switch>
              <Route exact path="/" component={Login} />
              <Route path="/login" component={Login} />
              <Route path="/dashboard" component={Dashboard} />
            </Switch>
          </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
