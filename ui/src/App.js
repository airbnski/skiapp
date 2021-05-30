import "./App.css";
import TopAppBar from "./components/TopAppBar";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Resorts from "./components/Resorts";
import HomePage from "./components/HomePage";
import {resortServiceUrl} from "./config";
import axios from "axios";
import {useEffect, useState} from "react";

function App() {

    const [resortList, setResortList] = useState([])
    const [filteredResortList, setFilteredResortList] = useState([])
    const [allResortsList, setAllResortsList] = useState([])

    useEffect(() => {
        getAllResortInfoFromAPI()
    }, [])

    const getAllResortInfoFromAPI = () => {
        axios.get(resortServiceUrl + '/resort')
            .then(res => {
                console.log('GET ALL RESORTS: ', res.data);
                updateResortList(res.data, ['all']);
            })
    }

    const updateResortList = (resorts, type = ['normal']) => {
        const newList = resorts.map((resort, index) => {
            return {
                id: resort.id,
                name: resort.name,
                website: resort.website,
                distance: resort.distance,
                skiMapUrl: resort.image,
                weather: {outlook: resort.weather.outlook, temperature: resort.weather.temperature > 200 ? resort.weather.temperature - 273.15 : resort.weather.temperature},
                slopes: {
                    easy: resort.slope ? resort.slope.easyDistance : resort.slopes ? resort.slopes.easy : 0,
                    medium: resort.slope ? resort.slope.mediumDistance : resort.slopes ? resort.slopes.medium : 0,
                    hard: resort.slope ? resort.slope.hardDistance :  resort.slopes ? resort.slopes.hard : 0
                },
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
        if (type.includes('all')) {
            setAllResortsList(uniqueResorts)
            console.log('All resorts updated', uniqueResorts)
        }
        if (type.includes('normal')) {
            setResortList(uniqueResorts)
            console.log('Normal resorts updated', uniqueResorts)

        }
        if (type.includes('filtered')) {
            setFilteredResortList(uniqueResorts)
            console.log('Filtered resorts updated', uniqueResorts)
        }
    }

    const clearResorts = () => {
        setResortList([])
    }

    return (
        <Router className="App">
            <Switch>
                <Route path="/map">
                    <TopAppBar/>
                    <Resorts updateResortList={updateResortList} resortList={resortList}
                             filteredResortList={filteredResortList} clearResorts={clearResorts}/>
                </Route>
                <Route path="/">
                    <HomePage/>
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
