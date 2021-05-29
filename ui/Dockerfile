# build environment
FROM node:12.22.1-alpine as build
WORKDIR  /ui
ENV PATH /ui/node_modules/.bin:$PATH
COPY package.json ./
RUN npm install --silent
RUN npm install react-scripts@3.4.1 -g --silent
COPY . ./
RUN npm run build
# production environment
FROM nginx:stable-alpine
COPY --from=build /ui/build usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
