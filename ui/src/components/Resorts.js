import axios from 'axios';

import InteractiveMap from "./InteractiveMap";
import ResortList from "./ResortList";
import {Grid, InputAdornment, TextField} from "@material-ui/core";
import {useEffect, useState} from "react";
import Sun from "../images/001-sun.svg";
import Cloud from "../images/002-cloud.svg";
import Rain from "../images/003-rain.svg";
import Cloudy from "../images/004-cloudy.svg";
import Snow from "../images/005-snowflake.svg";
import LocationOnOutlinedIcon from '@material-ui/icons/LocationOnOutlined';
import {positionStackAPIKey, positionStackUrl, resortServiceUrl} from '../config';


function Resorts() {
    const [resortList, setResortList] = useState([]);
    // const resortIds = [3725, 15168, 3828, 1023, 3839, 15169, 4392, 1020, 1022, 4394, 1021, 3792]
    const weather = ['Sun', 'Cloud', 'Rain', 'Cloudy', 'Snow']
    const [searchLocation, setSearchLocation] = useState('Zurich')
    const [searchLatitude, setSearchLatitude] = useState(0)
    const [searchLongitude, setSearchLongitude] = useState(0)


    useEffect(() => {
        searchForResorts()
    }, [])

    const searchForResorts = (loc = searchLocation) => {
        setResortList([])
        getSearchCoordinates(loc)
            .then(potentialLocation => {
                console.log('potentialLocation: ', potentialLocation)
                if (potentialLocation) {
                    setSearchLatitude(potentialLocation.latitude)
                    setSearchLongitude(potentialLocation.longitude)
                    getResortsByLocation(potentialLocation.longitude, potentialLocation.latitude)
                }
            })
    }

    const getResortsByLocation = (longitude , latitude ) => {
        axios.get(resortServiceUrl + '/resort/' + longitude + '/' + latitude + '/' + 25.0)
            .then(res => {
                console.log('GET RESORTS BY LOCATION: ', res.data)
                res.data.map((resort, index) => (
                    updateResortList(resort, index)));
            })
    }

    const updateResortList = (resort, index) => {
        if (!resortList.includes(resort.id)) {
        setResortList((prevState) => [...prevState, {
            id: resort.id,
            name: resort.name,
            website: resort.website,
            skiMapUrl: resort.image,
            weather: weather[index % weather.length],
            slopes: {easy: 150, medium: 90, hard: 30},
            location: {latitude: resort.latitude, longitude: resort.longitude}
        }]) }
    }

    /* Potential Functions for the future...

    const getAllResortInfo = () => {

        resortIds.map((id, index) => getResortInfo(id, index))
    }

    const getAllResortInfoFromAPI = () => {
        axios.get(resortServiceUrl + '/resort')
            .then(res => {
                console.log('GET ALL RESORTS: ', res.data);
                res.data.map((resort, index) => (
                    updateResortList(resort, index)));
            })
    }

    const getResortsById = () => {
        resortIds.map((id, index) => getResortInfoById(id, index))
    }

    const getResortInfoById = (resortId, index) => {
        axios.get(resortServiceUrl + '/resort/' + resortId)
            .then(res => {
                console.log('GET RESORT INFO BY ID: ', res.data);
                updateResortList(res.data, index)
            })
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

     */


    const getSearchCoordinates = (loc = searchLocation) => {
        console.log("GET SEARCH COORDINATES FOR ", loc)
        return axios.get(positionStackUrl + '/forward' + '?access_key=' + positionStackAPIKey + '&query=' + loc)
            .then(res => {
                return res.data.data[0]
            })
    }

    const handleKeyPress = (e) => {
        if (e.keyCode === 13) {
            console.log('value', e.target.value)
            searchForResorts(e.target.value)
        }
    }

    return (
        <Grid container spacing={2} style={{margin: 0}}>
            <Grid item xs={3} style={{height: 'calc(100vh - 70px)', overflowY: 'auto'}}>
                <TextField id="location" type="text" label="Location" variant="outlined"
                           InputProps={{
                               startAdornment: (
                                   <InputAdornment position="start">
                                       <LocationOnOutlinedIcon/>
                                   </InputAdornment>
                               ),
                           }}
                           style={{width: '90%', margin: 10}}
                           value={searchLocation}
                           onChange={(e, s) => setSearchLocation(s)}
                           onKeyDown={handleKeyPress}
                />
                <ResortList resorts={resortList}/>
            </Grid>
            <Grid item xs={9} style={{height: 'calc(100vh - 70px)'}}>
                <InteractiveMap resorts={resortList} lat={searchLatitude} long={searchLongitude}/>
            </Grid>
        </Grid>
    );
}

export default Resorts;
