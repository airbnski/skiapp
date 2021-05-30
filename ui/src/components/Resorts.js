import axios from 'axios';

import InteractiveMap from "./InteractiveMap";
import ResortList from "./ResortList";
import Filters from "./Filters";
import {Grid, InputAdornment, MenuItem, Select, TextField} from "@material-ui/core";
import {useEffect, useState} from "react";
import Sun from "../images/001-sun.svg";
import Cloud from "../images/002-cloud.svg";
import Rain from "../images/003-rain.svg";
import Cloudy from "../images/004-cloudy.svg";
import Snow from "../images/005-snowflake.svg";
import LocationOnOutlinedIcon from '@material-ui/icons/LocationOnOutlined';
import FilterListIcon from '@material-ui/icons/FilterList';
import {positionStackAPIKey, positionStackUrl, resortServiceUrl} from '../config';


function Resorts() {
    const [resortList, setResortList] = useState([]);
    // const resortIds = [3725, 15168, 3828, 1023, 3839, 15169, 4392, 1020, 1022, 4394, 1021, 3792]
    const weather = ['Sun', 'Cloud', 'Rain', 'Cloudy', 'Snow']
    const [searchLocation, setSearchLocation] = useState('Zurich')
    const [searchLatitude, setSearchLatitude] = useState(0)
    const [searchLongitude, setSearchLongitude] = useState(0)
    const [searchDistance, setSearchDistance] = useState(1000)
    const [showFilters, setShowFilters] = useState(false)


    useEffect(() => {
        searchForResorts()
    }, [])

    const searchForResorts = (loc = searchLocation, dist = searchDistance) => {
        setResortList([])
        if (dist !== searchDistance) {
            setSearchDistance(dist)
        }
        getSearchCoordinates(loc)
            .then(potentialLocation => {
                console.log('potentialLocation: ', potentialLocation)
                if (potentialLocation) {
                    setSearchLatitude(potentialLocation.latitude)
                    setSearchLongitude(potentialLocation.longitude)
                    getResortsByLocation(potentialLocation.longitude, potentialLocation.latitude, dist)
                }
            })
    }

    const getResortsByLocation = (longitude, latitude, radius) => {
        axios.get(resortServiceUrl + '/resort/' + longitude + '/' + latitude + '/' + radius)
            .then(res => {
                console.log('GET RESORTS BY LOCATION: ', res.data)
                updateResortList(res.data);
            })
    }

    const updateResortList = (resorts) => {
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
        setResortList(uniqueResorts)
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
                <div style={{display: 'flex', flexDirection: 'row', alignItems: 'center'}}>
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
                    <FilterListIcon style={{ fontSize: 40 }} onClick={() => setShowFilters(!showFilters)}/>
                </div>
                <ResortList resorts={resortList}/>
            </Grid>
            <Grid item xs={9} style={{height: 'calc(100vh - 70px)'}}>
                <InteractiveMap resorts={resortList} lat={searchLatitude} long={searchLongitude}/>
            </Grid>
            { showFilters ? <Filters open={showFilters} handleClose={() => setShowFilters(!showFilters)} search={searchForResorts} loc={searchLocation} currentDistance={searchDistance}/> : null}
        </Grid>
    );
}

export default Resorts;
