import "./App.css";
import TopAppBar from "./components/TopAppBar";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Resorts from "./components/Resorts";
import HomePage from "./components/HomePage";
import {resortServiceUrl} from "./config";
import axios from "axios";
import {useEffect, useState} from "react";

function App() {

    const [resortList, setResortList] = useState([]);
    const [allResortsList, setAllResortsList] = useState([])

    useEffect(() => {
        getAllResortInfoFromAPI()
    }, [])

    const getAllResortInfoFromAPI = () => {
        axios.get(resortServiceUrl + '/resort')
            .then(res => {
                console.log('GET ALL RESORTS: ', res.data);
                updateResortList(res.data, true);
            })
    }

    const updateResortList = (resorts, all=false) => {
        const newList = resorts.map((resort, index) => {
            return {
                id: resort.id,
                name: resort.name,
                website: resort.website,
                distance: resort.distance,
                skiMapUrl: resort.image,
                weather: {outlook: resort.weather.outlook, temperature: resort.weather.temperature},
                slopes: {easy: resort.slope? resort.slope.easyDistance: 0, medium: resort.slope? resort.slope.mediumDistance: 0, hard: resort.slope? resort.slope.hardDistance: 0},
                location: {latitude: resort.latitude, longitude: resort.longitude},
                status: resort.status
            }
        })
        const uniqueResorts = []
        const resortIDsSeen = []
        newList.forEach((r) => {
            if (!resortIDsSeen.includes(r.id)) {
                uniqueResorts.push(r)
            }
            resortIDsSeen.push(r.id)
        })
        if (all) setAllResortsList(uniqueResorts)
        else setResortList(uniqueResorts)
    }

    const clearResorts = () => {
        setResortList([])
    }

    return (
        <Router className="App">
            <Switch>
                <Route path="/map">
                    <TopAppBar/>
                    <Resorts updateResortList={updateResortList} resortList={resortList} clearResorts={clearResorts}/>
                </Route>
                <Route path="/">
                    <HomePage/>
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
