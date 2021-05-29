import "./App.css";
import TopAppBar from "./components/TopAppBar";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Resorts from "./components/Resorts";
import HomePage from "./components/HomePage";

function App() {
    return (
        <Router className="App">
            <Switch>
                <Route path="/map">
                    <TopAppBar/>
                    <Resorts/>
                </Route>
                <Route path="/">
                    <HomePage/>
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
