#!/usr/bin/env bash
kafka-topics --create --zookeeper localhost:32181 --replication-factor 1 --partitions 1 --topic counts