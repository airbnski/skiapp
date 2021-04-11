import "./App.css";
import AppBar from "./components/AppBar";
import InteractiveMap from "./components/InteractiveMap";
import ResortList from "./components/ResortList";
import {Grid, InputAdornment, TextField} from "@material-ui/core";
import {useEffect, useState} from "react";
import Sun from "./images/001-sun.svg";
import Cloud from "./images/002-cloud.svg";
import Rain from "./images/003-rain.svg";
import Cloudy from "./images/004-cloudy.svg";
import Snow from "./images/005-snowflake.svg";
import LocationOnOutlinedIcon from '@material-ui/icons/LocationOnOutlined';

function App() {
    const [resortList, setResortList] = useState([]);
    const resortIds = [3725, 15168, 3828, 1023, 3839, 15169, 4392, 1020, 1022, 4394, 1021, 3792]
    const weather = ['Sun', 'Cloud', 'Rain', 'Cloudy', 'Snow']

    useEffect(() => {
        getAllResortInfo()
    }, [])

    const getAllResortInfo = () => {
        resortIds.map((id, index) => getResortInfo(id, index))
    }

    const getResortInfo = (resortId, index) => {
        const url = 'https://skimap.org/SkiAreas/view/' + resortId + '.json';
        fetch(url)
            .then(resp => resp.json())
            .then(data => {
                setResortList((prevState) => [...prevState, {
                    id: resortId,
                    name: data.name,
                    website: data.official_website,
                    skiMapUrl: data.ski_maps[0].media.original.url,
                    weather: weather[index % weather.length],
                    slopes: {easy: 150, medium: 90, hard: 30},
                    location: {latitude: data.latitude, longitude: data.longitude}
                }]);
            })
    }

    return (
        <div className="App">
            <AppBar/>
            <Grid container spacing={2} style={{margin: 0}}>
                <Grid item xs={3} style={{height: 'calc(100vh - 70px)', overflowY: 'auto'}}>
                    <TextField id="location" type="text" default={"Zurich"} label="Location" variant="outlined"
                               InputProps={{
                                   startAdornment: (
                                       <InputAdornment position="start">
                                           <LocationOnOutlinedIcon />
                                       </InputAdornment>
                                   ),
                               }}
                               style={{width: '90%', margin: 10}}
                    />
                    <ResortList resorts={resortList}/>
                </Grid>
                <Grid item xs={9} style={{height: 'calc(100vh - 70px)'}}>
                    <InteractiveMap resorts={resortList}/>
                </Grid>
            </Grid>
        </div>
    );
}

export default App;
