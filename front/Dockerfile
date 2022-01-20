#
# Build angular
#
FROM node:12.22.9-alpine as angular
WORKDIR /app    
COPY package.json /app
RUN npm install --silent
COPY . .
RUN npm run build



#
# Build nginx server
#
FROM nginx:alpine
VOLUME /var/cache/nginx
COPY --from=angular app/dist/fisiotech /usr/share/nginx/html
COPY ./config/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80


# #
# # Build angular
# #
# FROM node:12.22.9-alpine as angular
# WORKDIR /app    
# COPY . ./app
# COPY package.json /app
# RUN ls
# RUN npm install
# RUN npm build 


# #
# # Build nginx server
# #
# FROM nginx:alpine
# VOLUME /var/cache/nginx
# COPY --from=angular app/ /usr/share/nginx/html
# COPY ./config/nginx.conf /etc/nginx/conf.d/default.conf
# EXPOSE 80

